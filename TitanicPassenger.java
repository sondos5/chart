/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sondos
 */
public class TitanicPassenger {
    private String pclass;
    private String survived;
    private String name;
    private String sex;
    private float age;
    private String sipsb;
    private String parch;
    private String ticket;
    private float fare;
    private String cabin;
    private String embarked;
    private String boat;
    private String home_dist;
    private String body;
    
    TitanicPassenger (String pclass,String survived,String name,String sex,float age,String sipsb,String parch,
            String ticket,float fare,
            String cabin,String embarked,String boat,String body,String home_dist){
        this.pclass = pclass;
        this.survived = survived;
        this.name = name;
        this.sex = sex;
        this.age=age;
        this.sipsb = sipsb;
        this.parch = parch;
        this.ticket =ticket;
        this.fare =fare;
        this.cabin = cabin;
        this.embarked =embarked;
        this.boat =boat;
        this.body =body;
        this.home_dist =home_dist;
        
                
        
    }
    public String getPclass(){
        return pclass;
    }
    
    void setPclass(String pclass){
        this.pclass = pclass;   
    }
     public String getSurvived(){
        return survived;
    }
    void setSurvived(String survived){
        this.survived = survived;   
    }
     public String getName(){
        return name;
    }
    void setName(String name){
        this.name = name;   
    }
    public String getSex(){
        return sex;
    }
    void setSex(String sex){
        this.sex = sex;   
    } 
    public float getAge(){
        return  age;
    }
    void setAge(float age){
        this.age = age;   
    }
    public String getSipsb(){
        return sipsb;
    }
    void setSipsb(String sipsb){
        this.sipsb= sipsb;   
    }
     public String getParch(){
        return parch;
    }
    void setParch(String parch){
        this.parch= parch;   
    }
     public String getTicket(){
        return ticket;
    }
    void setTicket(String ticket){
        this.ticket= ticket;   
    }
    public float getFare(){
        return fare;
    }
    void setFare(float fare){
        this.fare= fare;   
    }
    public String getcabin(){
        return cabin;
    }
    void setcabin(String cabin){
        this.cabin= cabin;   
    }
    public String getembarked(){
        return embarked;
    }
    void setembarked(String embarked){
        this.embarked= embarked;   
    }
    public String getboat(){
        return boat;
    }
    void setboat(String boat){
        this.boat= boat;   
    }
    public String getbody(){
        return body;
    }
    void setbody(String body){
        this.body= body;   
    }
    public String gethome_dist(){
        return embarked;
    }
    void sethome_dist(String home_dist){
        this.home_dist= home_dist;   
    }
    @Override
    public String toString() {
        return  getName();
    }
}
