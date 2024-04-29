public class Email {
    private String email; 
    public Email(String email) {
        this.email = email;
    };
    
    public boolean validateEmail() throws InvalidEmailException, InvalidDomainException {
        if (email == "") {
            throw new InvalidEmailException("Email tidak boleh kosong");
        }

        int atSymbolIndex = email.indexOf("@");
        int lastSymbolIndex = email.lastIndexOf("@");

        if (atSymbolIndex == -1) {
            throw new InvalidEmailException("Email harus mengandung tepat satu buah @");
        }
        
        if (atSymbolIndex != lastSymbolIndex) {
            throw new InvalidEmailException("Email harus mengandung tepat satu buah @");
        }

        if (atSymbolIndex == 0) {
            throw new InvalidEmailException("@ tidak boleh di awal email");
        }

        if (atSymbolIndex == email.length() - 1) {
            throw new InvalidDomainException();
        }

        int periodIndex = email.indexOf(".", atSymbolIndex + 1);

        if (periodIndex == atSymbolIndex + 1) {
            throw new InvalidDomainException();
        }

        if (periodIndex == -1) {
            throw new InvalidDomainException();
        }

        if (periodIndex == email.length() - 1) {
            throw new InvalidDomainException();
        }

        return true;
    }

}

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class InvalidDomainException extends Exception {
    public InvalidDomainException() {
        super("Email harus memiliki domain yang valid");
    }
}