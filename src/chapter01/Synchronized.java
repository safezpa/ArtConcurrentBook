package chapter01;

public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class){

        }
    }

    public static synchronized void m(){

    }
}

/*
Classfile Synchronized.class
        Last modified 2017-8-2; size 447 bytes
        MD5 checksum 4905c70e93f2ee79c0eded3d5b268772
        Compiled from "Synchronized.java"
public class Synchronized
        minor version: 0
        major version: 52
        flags: ACC_PUBLIC, ACC_SUPER
        Constant pool:
        #1 = Methodref          #3.#17         // java/lang/Object."<init>":()V
        #2 = Class              #18            // Synchronized
        #3 = Class              #19            // java/lang/Object
        #4 = Utf8               <init>
        #5 = Utf8               ()V
        #6 = Utf8               Code
        #7 = Utf8               LineNumberTable
        #8 = Utf8               main
        #9 = Utf8               ([Ljava/lang/String;)V
        #10 = Utf8               StackMapTable
        #11 = Class              #20            // "[Ljava/lang/String;"
        #12 = Class              #19            // java/lang/Object
        #13 = Class              #21            // java/lang/Throwable
        #14 = Utf8               m
        #15 = Utf8               SourceFile
        #16 = Utf8               Synchronized.java
        #17 = NameAndType        #4:#5          // "<init>":()V
        #18 = Utf8               Synchronized
        #19 = Utf8               java/lang/Object
        #20 = Utf8               [Ljava/lang/String;
        #21 = Utf8               java/lang/Throwable
{
public Synchronized();
        descriptor: ()V
        flags: ACC_PUBLIC
        Code:
            stack=1, locals=1, args_size=1
                0: aload_0
                1: invokespecial #1                  // Method java/lang/Object."<init>":()V
                4: return
            LineNumberTable:
                line 1: 0

public static void main(java.lang.String[]);
        descriptor: ([Ljava/lang/String;)V
        flags: ACC_PUBLIC, ACC_STATIC
        Code:
        stack=2, locals=3, args_size=1
            0: ldc           #2                  // class Synchronized
            2: dup
            3: astore_1
            4: monitorenter
            5: aload_1
            6: monitorexit
            7: goto          15
            10: astore_2
            11: aload_1
            12: monitorexit
            13: aload_2
            14: athrow
            15: return
        Exception table:
            from    to  target type
            5       7       10   any
            10      13      10   any
        LineNumberTable:
            line 3: 0
            line 5: 5
            line 6: 15
        StackMapTable: number_of_entries = 2
            frame_type = 255 // full_frame
                offset_delta = 10
                locals = [ class "[Ljava/lang/String;", class java/lang/Object ]
                stack = [ class java/lang/Throwable ]
            frame_type = 250 // chop
                offset_delta = 4

public static synchronized void m();
        descriptor: ()V
        flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
        Code:
            stack=0, locals=0, args_size=0
                0: return
            LineNumberTable:
                line 10: 0
        }
SourceFile: "Synchronized.java"
*/
