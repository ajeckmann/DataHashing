import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class FileReading {




public static void main(String[] args) throws IOException, FileNotFoundException {

//set relative path here:
// String Path = "/Users/ari/Documents/CodingDojo/Java/HashFile/src/"; //DEFINE file path. This will equal whatever is selected by the user.
String Path = args[0]; 
String stringPath = Path+"/InputFiles/"+args[1];
System.out.println("stringPath is "+stringPath);
String lineToRead = "";
String firstLine = "";
ArrayList columnsToHash = new ArrayList<>();

try {
BufferedReader br = new BufferedReader(new java.io.FileReader(stringPath));
String exportFile = "";
//will be the new file we export

firstLine = br.readLine();
//set this variable equal to the first line from the csv, which should be just column titles

System.out.println("first line is: "+firstLine);//verify this is what it is.

System.out.println();
String[] firstLineValues = firstLine.split(",");
System.out.println();
//parse values of first line, save values in string array; we do NOT need to hash values in this first line as it is only headers.
System.out.println("firstLine Values Array:"+Arrays.toString(firstLineValues));

for (int i = 2; i<args.length; i++) {
try{

// if (findIndex(firstLineValues, args[i])<0){
// System.out.println("Please Enter a properly spelled column name");
// throw new FileNotFoundException();
//
// }
if(findIndex(firstLineValues, args[i]) == null){
System.out.println("incorrect column name. Make sure all column names are correct");
System.exit(0);
}
columnsToHash.add(findIndex(firstLineValues, args[i]));
System.out.println(findIndex(firstLineValues, args[i]));
}
catch(Exception e){
e.printStackTrace();
}
}
System.out.println("columns to hash "+columnsToHash);

for (int i = 0; i < firstLineValues.length; i++) {
exportFile = exportFile.concat(firstLineValues[i] + ",");//add all the values (column headers) to the exportFile.
System.out.println(i+": " +firstLineValues[i]);
}

exportFile = exportFile.concat("\n");//go to a new line after adding the first line of column headers.

for (int i = 0; i<columnsToHash.size(); i++){
System.out.println((int)(columnsToHash.get(i)));
}
while ((lineToRead = br.readLine()) != null) { ///lineToRead becomes the next line to be read and is then read, so long as it is not null
String[] lineValues = lineToRead.split(","); //The column values are made into a string array.



//within each line, loop through the parsed values, and concat them onto the exportFile

for (int i = 0; i < lineValues.length; i++) {
;
if (columnsToHash.contains(i)) { ////IF VALUE APPEARS IN COLUMN SPECIFIED, hash it by running function and then concat hashed value
exportFile = exportFile.concat(getMd5(lineValues[i]) + ",");
continue;
}
exportFile = exportFile.concat(lineValues[i] + ",");
}
exportFile = exportFile.concat("\n");

}
System.out.println("new file is: " + exportFile);


FileWriter ourWriter = new FileWriter(Path + "/ExportedFile/HASHED"+args[1]);
System.out.println("ourWriter: "+Path + "ExportedFile/HASHED7"+args[1]);



ourWriter.write(exportFile);
System.out.println("Your file has been exported. Please retrieve it from the ExportedFile folder");
ourWriter.close();
} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
}


System.out.println();

}
public static String getMd5(String input) {
try {
MessageDigest md = MessageDigest.getInstance("MD5");

byte[] messageDigest = md.digest(input.getBytes());

BigInteger no = new BigInteger(1, messageDigest);

String hashtext = no.toString(16);

while (hashtext.length() < 32) {
hashtext = "0" + hashtext;
}
return hashtext;
} catch (NoSuchAlgorithmException e) {
throw new RuntimeException(e);

}
}


public static Object findIndex(String[] arr, String target) throws FileNotFoundException{
for (int i = 0; i < arr.length; i++) {
if (arr[i].equals(target)) return i;
}
return null;
}

}