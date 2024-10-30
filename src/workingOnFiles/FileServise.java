package workingOnFiles;

public class FileServise
{
    final static String PATH_PRODUCT_FILE = "D:\\Java\\2. Project\\Calorie Calculator Project\\src\\file\\productFile.csv";
    final static String PATH_FOOD_FILE = "D:\\Java\\2. Project\\Calorie Calculator Project\\src\\file\\foodFile.csv";
    static String[] parse (String line)
    {
        return line.split("||");
    }

}
