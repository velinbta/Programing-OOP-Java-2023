1. Harvesting Fields 
You are given a RichSoilLand class with lots of fields (look at the provided skeleton).
Like the good farmer you are, you must harvest them.
Harvesting means that you must print each field in a certain format (see output).

Input 
You will receive a maximum of 100 lines with one of the following commands:
private - print all private fields
protected - print all protected fields
public - print all public fields
all - print ALL declared fields
HARVEST - end the input

Output 
For each command, you must print the fields that have the given access modifier as described in the input section.
The format in which the fields should be printed is:
"{access modifier} {field type} {field name}"

Examples:

Input 1:
protected
HARVEST

Output 1:
protected String testString
protected double aDouble
protected byte testByte
protected StringBuilder aBuffer
protected BigInteger testBigNumber
protected float testFloat
protected Object testPredicate
protected Object fatherMotherObject
protected String moarString
protected Exception inheritableException
protected Stream moarStreamz

Input 2:
private
public
private
HARVEST

Output 2:
private int testInt
private long testLong
private Calendar aCalendar
private char testChar
private BigInteger testBigInt
private Thread aThread
private Object aPredicate
private Object hiddenObject
private String anotherString
private Exception internalException
private Stream secretStream
public double testDouble
public String aString
public StringBuilder aBuilder
public short testShort
public byte aByte
public float aFloat
public Thread testThread
public Object anObject
public int anotherIntBitesTheDust
public Exception justException
public Stream aStream
private int testInt
private long testLong
private Calendar aCalendar
private char testChar
private BigInteger testBigInt
private Thread aThread
private Object aPredicate
private Object hiddenObject
private String anotherString
private Exception internalException
private Stream secretStream

Input 3:
all
HARVEST

Output 3:
private int testInt
public double testDouble
protected String testString
private long testLong
protected double aDouble
public String aString
private Calendar aCalendar
public StringBuilder aBuilder
private char testChar
public short testShort
protected byte testByte
public byte aByte
protected StringBuilder aBuffer
private BigInteger testBigInt
protected BigInteger testBigNumber
protected float testFloat
public float aFloat
private Thread aThread
public Thread testThread
private Object aPredicate
protected Object testPredicate
public Object anObject
private Object hiddenObject
protected Object fatherMotherObject
private String anotherString
protected String moarString
public int anotherIntBitesTheDust
private Exception internalException
protected Exception inheritableException
public Exception justException
public Stream aStream
protected Stream moarStreamz
private Stream secretStream