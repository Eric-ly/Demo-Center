package demo.javaBasic;


public class Generic
{
   public static void main(String[] args) {

   	GenericClass<String> name = new GenericClass<String>("corn");
   	GenericClass<Integer> age = new GenericClass<Integer>(712);
   	GenericClass<Number> number = new GenericClass<Number>(314);

      getData(name);
      getData(age);
      getData(number);
  }

  public static void getData(GenericClass<?> data) {
      System.out.println("data :" + data.getData());
  }
//  类型通配符上限，可以传入这个 类型以及这个类型的子类
  public static void getDataExtends(GenericClass<? extends Number> data){
     System.out.println("data :" + data.getData());
  }
//类型通配符下，可以传入这个 类型以及这个类型的父类
public static void getDataSuper(GenericClass<? super Number> data){
   System.out.println("data :" + data.getData());
}

}
