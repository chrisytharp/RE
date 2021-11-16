When java applications are compiled, they are turned into an intermediary form of machine code, known as bytecode. While java source code is designed to be easy for humans to read, bytecode is designed to be easy for machines to read.

When you execute a compiled java application the class file is read and interpreted by a Java Virtual Machine. This is like a custom virtual CPU that runs inside your existing CPU and follows a different instruction set, the JVM instruction set.

Java Bytecode is a stack based language. This means that temporary variables are stored in the stack, rather than how x86 stores in registers. Stacks are like buckets. When you add a variable to the stack, you put it at the top of the bucket. When you remove/use a variable from the stack you use the variable at the top of the stack. If you attempt to retrieve a variable from an empty stack this is known as a Stack Underflow. If you add too many variables such that the stack reaches its memory limit, this is known as a Stack Overflow (Think of a bucket overflowing from too many items).

The java bytecode to print "Hello World" to console is shown below:
  // Retrieve the static variable "out" in the System class and store it on the stack
  getstatic java/lang/System.out:Ljava/io/PrintStream; 
  
  // Load the string "Hello World" onto the stack
  ldc "Hello World"
  
  // Invoke the "println" function on the System.out variable using the string at the top of the stack as an argument
  invokevirtual java/io/PrintStream.println:(Ljava/lang/String;)V
  
Because JVM Bytecode is a high level representation of the original source code, constructs such as methods, fields and classes are still visible.

Classes are compiled into .class files, one class per file. These can reference other classes which will be linked by the JVM at runtime. By using a parser such as javap we are able to see the methods and fields present in a class. Each will have a name and a descriptor. The descriptor is a representation of the arguments and return type a method can take, or the type of a field.

The following method:

void main(String[] args, int i)

would produce this descriptor and name:

main([Ljava/lang/String;I)V

The args are surrounded in brackets. A [ brace represents an array. An object is represented by a fully qualified internal name prepended by an L and appended by an ;. The I represents an Int, and the V at the end represents the type void. A full writeup on descriptors can be seen here: https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html#jvms-4.3.



Javap is a tool bundled with JDK releases that can disassemble compiled classes. Example usage:

(p = show private members, v = verbose)

javap -v -p HelloWorld.class

PDF-----
DF's are capable of containing many more types of code that can be executed without the user's knowledge. This includes:

Javascript
Python
Executables
Powershell Shellcode

We'll be using 'peepdf' to begin a precursory analysis of a PDF file to determine the presence of Javascript. If there is, we will extract this Javascript code (without executing it) for our inspection.

We can simply do "peepdf demo_notsuspicious.pdf"

o extract this Javascript, we can use peepdf's "extract" module. This requires a few steps to set up but is fairly trivial.

The following command will create a script file for 'peepdf' to use:

      "echo 'extract js > javascript-from-demo_notsuspicious.pdf' > extracted_javascript.txt"

when placing the text "extract js > javascript-from-demo_notsuspicious.pdf" in a file and passing that file to peepdf, it will execute the cmd to extract
The script will extract all javascript via extract js and pipe > the contents into "javascript-from-demo_notsuspicious.pdf"

We now need to tell peepdf the name of the script (extracted_javascript.txt) and the PDF file that we want to extract from (demo_notsuspicious.pdf): 

    "peepdf -s extracted_javascript.txt demo_notsuspicious.pdf"
    
Remembering that the Javascript will output into a file called "javascript-from-demo_nonsuspicious.pdf" because of our script.

To recap: "extracted_javascript.txt" (highlighted in red) is our script, where "demo_notsuspicious.pdf" (highlighted in green) is the original PDF file that we think is malicious.

You will see an output, in this case, a file named "javascript-from-demo_notsuspicious" (highlighted in yellow). This file now contains our extracted Javascript, we can simply cat this to see the contents.
  'cat javascript-from-demo_notsuspicious.pdf'
  
