public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;
  // Constructor which takes in CharSequence datatype and takes length and creates array
  public MyString(CharSequence s){
    data = new char[s.length()];
    for (int index = 0; index < s.length(); index++){
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
    String string = "";
    for (int i = 0; i < returnValue.length; i++){
      string += returnValue[i];
    }
    return string;
  }
  // Method compares char sequences lexigraphically between eachother
  public int compareTo(CharSequence anotherString){
    if (anotherString == null || this == null){
      throw new NullPointerException();
    }
    else if (anotherString.equals(this)){
      return 0;
    }
    else if (anotherString != "" && data.length == 0){
      return 1;
    }
    else if (anotherString == "" && data.length == 0){
      return 0;
    }
    int smaller = Math.min(anotherString.length(), this.length());
    for (int i = 0; i < smaller; i ++){
      if (anotherString.charAt(i)+0 > this.charAt(i)+0){
        return -1;
      }
      else if (anotherString.charAt(i)+0<this.charAt(i)+0){
        return 1;
      }
    }
    if (this.length() != anotherString.length()){
      return this.length() - anotherString.length();
    }
    return 0;
  }
  // Method that returns string version of sequence
  public String toString(){
    String string = "";
    for (int i = 0; i < this.length(); i++){
      string += this.charAt(i);
    }
    return string;
  }
}
