
import java.io.*;
import java.util.Scanner; 		
class FileClass1{
	public static void main(String[] args) throws IOException{
		//	1-	Create a directory named "dirTest" under c:\ 
		File dirTest = new File("C:\\dirTest");		// File f = new File(String s)
		boolean b = dirTest.mkdir();
		if (b==true)
			System.out.println("the directory " + dirTest.getName() + " is created");
		else 
			System.out.println("the directory " + dirTest.getName() + " is not created");
		
		//	2-	Create the tree "C:\\dirTest\\subDir1/subDir2".
		File tree = new File("C:\\dirTest\\subDir1/subDir2");
		b = tree.mkdirs();
		if (b)
			System.out.println("the directory " + tree.getName() + " is created");
		else 
			System.out.println("the directory " + tree.getName() + " is not created");
		
		//	3-	Get the absolute path of subDir2
		System.out.println("the absolute path of " + tree.getName() + " is " + tree.getAbsolutePath());
		
		//	4-	Add three text files "f1.txt", "f2.txt" and "f3.pdf" to dirTest
		File f1 = new File(dirTest, "f1.txt");			// File f = new File(File x, String s)
		try { 
			b = f1.createNewFile();
			System.out.println("the file " + f1.getName() + " is created");
		}catch (IOException e) {
			System.out.println("the file " + f1.getName() + " is not created");
		}
		
		File f2 = new File(dirTest, "f2.txt");			// File f = new File(File x, String s)
		try { 
			b = f2.createNewFile();
			System.out.println("the file " + f2.getName() + " is created");
		}catch (IOException e){
			System.out.println("the file " + f1.getName() + " is not created");
		}
		
		File f3 = new File(dirTest, "f3.pdf");			// File f = new File(File x, String s)
		try {
			b = f3.createNewFile();
			System.out.println("the file " + f3.getName() + " is created");
		}catch (IOException e) {
			System.out.println("the file " + f3.getName() + " is not created");
		}
		//	5-	Get the parent of subDir1    
		// first method
		//  File subDir1 = new File ("C:\\dirTest\\subDir1);
		//  System.out.println("the parent of subdir1 is " + subDir1.getParentFile());
		
		File parent = tree.getParentFile().getParentFile();
		
		//	6-	Get the number of files in the parent of subDir1.
		System.out.println("the number of files in " + parent.getName() + " is " + parent.list().length);
		
		//	7-	Compare the two files "f1.txt" and "f2.txt".
		if (f1.exists() && f2.exists()){ 
			int v = f1.compareTo(f2);
			if (v==0)
				System.out.println("the file " + f1.getName() + " is equal " + f2.getName());
			else 
				if (v>0) 
					System.out.println("the file " + f1.getName() + " is greater than " + f2.getName());
				else
					System.out.println("the file " + f1.getName() + " is less than " + f2.getName()); 
		}
		if (f1.exists()){
			//	8-	Make the "f1.txt" a read only file.
			b = f1.setReadOnly();
			if (b)
				System.out.println("the file " + f1.getName() + " is read only");
			else 
				System.out.println("the file " + f1.getName() + " is not read only");
			
			//	9-	Test if you can write to "f1.txt". If not, let the user can write to it.
			b= f1.canWrite();
			if (b)
				System.out.println("the file " + f1.getName() + " is writable");
			else{		
					System.out.println("the file " + f1.getName() + " is not writable");
					b = f1.setWritable(true);
					if (b)
						System.out.println("the file " + f1.getName() + " is set as writable");
					else		
						System.out.println("the file " + f1.getName() + " is not set as writable");
			}
			//	11-	Do not let the user read from "f1.txt"	
			b = f1.setReadable(false);
			if (b)
				System.out.println("the file " + f1.getName() + " is not reable");
			else 
				System.out.println("the file " + f1.getName() + " is readable");
		}
		//	10-	Do not let the user write to "f2.txt"
		if (f2.exists()){
			b = f2.setWritable(false);
			if (b)
				System.out.println("the file " + f2.getName() + " is not writable");
			else 
				System.out.println("the file " + f2.getName() + " is writable");
		}
		
		if (tree.exists()){
			//	12-	Do not let the user execute "subDir2"
			b = tree.setExecutable(false);
			if (b)
				System.out.println("the file " + tree.getName() + " is not executable");
			else 
				System.out.println("the file " + tree.getName() + " is executable");
			//	13-	Rename "subDir2" to "Dir2"
			File dir2 = new File("C:\\dirTest\\subDir1/Dir2");
			b= tree.renameTo(dir2);
			if (b)
				System.out.println("the file " + tree.getName() + " is renamed " + dir2.getName());
			else 
				System.out.println("the file " + tree.getName() + " is not renamed to " + dir2.getName());
		}
		//	14-	Display a list of contents of "dirTest" with their type (file/directory) and length
		if (dirTest.exists()){
			File[] f = dirTest.listFiles();
			for (int i=0; i< f.length; i++){
				if (f[i].isDirectory())
					System.out.println(f[i].getName() + " is a directory having the length " + f[i].length());
				else
					System.out.println(f[i].getName() + " is a normal file having the length " + f[i].length());
			}
			//	15-	Display a list of text files in "dirTest"
			System.out.println("list of text files in " + dirTest.getName());
			String[] s = dirTest.list();
			for (int i=0; i< s.length; i++){
				if (s[i].endsWith("txt"))
					System.out.println(s[i]); 
			}
			
		}
		//	16-	Test if we can read from, write to and execute "subDir1".	
		b= tree.getParentFile().canRead();
		if (b)
				System.out.println("the directory " + tree.getParentFile().getName() + " is readable");
		else 
				System.out.println("the file " + tree.getName() + " is not readable");
		
		//	Write a java program with the following tasks. Add the corresponding message for each task.
		deleteFile(f1);
		deleteFile(f2);
		deleteFile(f3);
		deleteFile(tree);
		deleteFile(dirTest);
		
	}
	static void deleteFile(File f){
		System.out.println("do you want to delete the file " + f.getName() + " y/n: ");
		Scanner in = new Scanner(System.in);
		String ans = in.next();
		if (ans.equals("y") || ans.equals("Y")){
			boolean b = f.delete();
			if (b)
				System.out.println(f.getName() + " is deleted");
			else 
				System.out.println(f.getName() + " is not deleted");
		}
	}
	
}