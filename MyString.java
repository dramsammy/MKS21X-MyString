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

  }
