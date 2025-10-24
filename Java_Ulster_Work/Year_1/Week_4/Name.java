public class Name {
    public static String firstName(String name){
        int space = name.indexOf(" ");
        return name.substring(0,space);
    }
    public static String lastName(String name){
        int space = name.indexOf(" ");
        return name.substring(space+1, name.length());
    }
    public static String shortName(String name){
        String sub = "";
        sub += name.charAt(0) + ".";
        sub +=  lastName(name);
        return sub;
    }

    public static void main(String[]args) {

        String name = "Joe Bloggs";
        System.out.println(firstName(name));
        System.out.println(lastName(name));
        System.out.println(shortName(name));
    }


}
