package study.java.code;

class Score{
	 
    private int score;
 
 
 
    public int getScore() {
 
        return score;
 
    }
 
 
 
    public void setScore(int score) {
 
        this.score = score;
 
    }
 
    
 
}
 
 
 
 
 
 
 
//학생1명
 
 
 
 
 
 
 
class STU{
 
    private    String name;
 
    private    Score kor,eng,math;
 
    
 
   STU(){}
 
   STU(String name,int kor,int eng, int ma){
 
       this.kor=new Score();
 
       this.eng=new Score();
 
       this.math=new Score();
 
       
 
       this.name=name;
 
       this.kor.setScore(kor);
 
       this.eng.setScore(eng);
 
       this.math.setScore(ma);
 
   }
 
   
 
   
 
   
 
   
 
public String getName() {
 
    return name;
 
}
 
public void setName(String name) {
 
    this.name = name;
 
}
 
public int getKor() {
 
    return kor.getScore();
 
}
 
public void setKor(int kor) {
 
    this.kor.setScore(kor);
 
}
 
public int getEng() {
 
    return eng.getScore();
 
}
 
public void setEng(int eng) {
 
    this.eng.setScore(eng);
 
}
 
public int getMath() {
 
    return this.math.getScore();
 
}
 
public void setMath(int math) {
 
    this.math.setScore(math);
 
}
 
 
 
public String toString(){
 
      return "이름 : "+name+" 국어:"+kor.getScore()+" 영어:"+eng.getScore()+" 수학:"+math.getScore()+" 총점:"+(kor.getScore()+eng.getScore()+math.getScore())+" 평균:"+(kor.getScore()+eng.getScore()+math.getScore())/3.f;
 
   }
 
}
 