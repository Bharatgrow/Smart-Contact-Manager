/*interface global{
    void anything(String str);
}
class jam implements global{
    public void anything(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        jam j=new jam();
        j.anything("hii there");
    }

}*/
interface global{
  default   void anyone(){
      System.out.println("come here");
    }
}
interface jam extends global{
    void one(String str);
}
class two implements jam{
    @Override
    public void one(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        two t=new two();
        t.one("hello world");
        t.anyone();
    }
}
