public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;
  // Constructor which takes in CharSequence datatype and takes length and creates array
  public MyString(CharSequence s){
    data = new char[s.length];
    for (int index = 0; index < data.length; index++){
      data[index] = s.charAt(index);
    }
  }
  // Method that returns length --- uses array length
  public int length(){
    return data.length;
  }
  // Method that returns postion of char at certain Index. Throws exception if index is below 0 or greater than length of sequence
  public char charAt(int index){
    if (index < 0 || index > length() - 1){
      throw new IndexOutOfBoundsException("Index is out of range");
    }
    return data[index];
  }
  // Method returns subSequence of data with start and end indices
  public CharSequence subSequence(int start, int end){
    if (start < 0 || start > end){
      throw new IndexOutOfBoundsException("Start is greater than end or less than 0");
    }
    if (end < 0 ){
      throw new IndexOutOfBoundsException("End is less than 0");
    }
    if (end > length()){
      throw new IndexOutOfBoundsException("End is out of range");
    }
    if (start == end){
      return "";
    }
    char[] returnValue = new char[end - start];
    int number = 0;
    while (start < end){
      returnValue[number] = data[start];
      start++;
      number++;
    }
    return new MyString(returnValue);
  }
  // Method compares char sequences lexigraphically between eachother
  public int compareTo(String anotherString){
    if (anotherString == null || this == null){
      throw new NullPointerException();
    }
    int longer = Math.max(anotherString.length(), this.length());
    for (int i = 0; i < longer; i ++){
      if (anotherString.charAt(i)+0 > this.charAt(i)+0){
        return -1;
      }
      else{
        return 1;
      }
    }


  }
}
