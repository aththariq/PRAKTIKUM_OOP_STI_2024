public class CheckType<T>{
    private T t;
    private String type;

    public CheckType(T t){
        this.t = t;
        this.type = t.getClass().getSimpleName();
    }
    public T getT(){
        return t;
    }
    public String getType(){
        return type;
    }
    public String printTypeandValue(){
        //Kembalikan nilai "Tipe: Nilai"
        //Contoh "String: Halo"
        return type + ": " + t;
    }
}