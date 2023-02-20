                                            Hashing Files with Sensitive Information

PURPOSE:
This program is designed to take a csv file and hash the data in specified columns. It can be used if files need to be transferred between parties but contain sensitive information that is not relevant to the work being done.


UNIX VERSION

Assumptions:
1: Ensure all files are .csv format;

2: Ensure no column names contain a comma. If there are, delete the commas and then change the column names back in the Hashed file, if need be. This will affect the resulting file. 

3: Ensure row 1 contains column names;


-Navigate to the program in your directory. You will see a folder titled "HashFile"
-Open this folder, and navigate into the src folder. Within the src folder, you should see a folder titled "InputFiles". 

-Drag the file you wish to hash into this folder. The hashed file will appear in the folder titled "ExportedFile" after you have run the program.

-Identify the absolute path to the src folder
Example: absolutePath = "/User/username/Documents/Projects/Java/HashFile/src"





Run the program:

-In the command prompt, navigate to the src folder
Example: "cd /User/username/Documents/Projects/Java/HashFile/src"

-Initiate command: javac FileReading.java

-Then, initiate command: java FileReading Arg1 Arg2 Arg 3 etc...

In place of :
Arg 1: Type the absolute path of the src folder that you identified earlier and then a space;

Arg 2: Type the File name you wish to hash exactly as it is named and then a space;

Arg 3 and onward: Type the names of columns you would like to mask exactly as they appear on the file. If there is a space or special character within the name, be sure to include the name in quotation marks.
 

Examples:

java FileReading /User/username/Documents/Projects/Java/HashFile/src fileToImport.csv Address City State Date

java FileReading /User/username/Documents/Projects/Java/HashFile/src fileToImport.csv Address "Date Added" City State

**notice the spaces between all arguments.



Retrieve your file from the FileOutput folder (HashFile/src/ExportedFile)

Be sure to remove from FileOutput folder.

If there is a mistake or you need to re-hash the same file, please delete the original exported file before doing so, as the newly generated one will have the same name. 


WINDOWS VERSION:

Assumptions:
1: Ensure all files are .csv format;

2: Ensure no column names contain a comma. If there are, delete them and then change them back in the Hashed folder, if need be. This will affect the resulting file. 

3: Ensure row 1 contains column names;


-Unzip and save the folder titled "HashFile"

-Open this folder, and navigate into the src folder. Within the src folder, you should see a folder titled "InputFiles". 

-Drag the file you wish to hash into this folder. The hashed file will appear in the folder titled "ExportedFile" after you have run the program.

-Identify the absolute path to the src folder. You will need it shortly
Example: absolutePath = "/User/username/Documents/Projects/Java/HashFile/src"


- Navigate to the src folder within the HashFile folder
Example: "cd /User/username/Documents/Projects/Java/HashFile/src"


- Initate command:   HashFilebuild.bat Arg1 Arg2 Arg2 etc....
In place of :

Arg 1: Type the absolute path of the src folder
Arg 2: Type the File name you wish to hash exactly as it is named;
Arg 3 and onward (UP TO 10 ARGS): Type the names of columns (<=10) you would like to mask exactly as they appear on the csv file. If there is a space or special character in the name, be sure to include the name in quotation marks.



Examples:
If you have a file called "fileToImport.csv" in the "InputFiles" folder, and you wish to hash the Address, City, State, and Date columns:

HashFilebuild.bat /User/username/Documents/Projects/Java/HashFile/src fileToImport.csv Address City State Date

If you have a file called "fileToImport.csv" in the "InputFiles" folder, and you wish to hash the Date Added, City, and State columns:
HashFilebuild.bat /User/username/Documents/Projects/Java/HashFile/src fileToImport.csv Address "Date Added" City State    (*notice quotation marks around column name with space included)


**notice the spaces between all arguments.

-After you've pressed enter and your file has been hashed successfully, look for a message stating your file has been exported. 

-Retrieve your file from the FileOutput folder (HashFile/src/ExportedFile)

-Be sure to remove your hashed file from FileOutput folder.

-If there is a mistake or you need to re-hash the same file, please delete the original exported file before doing so, as the newly generated one will have the same name. 
