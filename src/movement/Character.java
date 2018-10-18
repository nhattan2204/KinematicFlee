/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;

import java.util.Objects;

/**
 *
 * @author PhamNhatTan
 */
public class Character {
    private float rotation;
    private float orientation;
    private Vector2D position;
    private Vector2D velocity;

    public float getRotation() {
        return rotation;
    }

    public float getOrientation() {
        return orientation;
    }

    public Vector2D getPosition() {
        return position;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void setOrientation(float orientation) {
        this.orientation = orientation;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }
    
    public Character(){}
    
    public Character(Vector2D position,Vector2D velocity, float rotation, float orientation){
        this.position = position;
        this.orientation = orientation;
        this.rotation = rotation;
        this.velocity = velocity;
    }
    
    @Override
    public int hashCode(){
        int hash = 3;
        return hash;
    }
    
    @Override
    public boolean  equals(Object obj){
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
        return false;
        }
        final Character other =(Character) obj;
        if (!Objects.equals(this.position, other.position)){
            return false;
        }
        if (Float.floatToIntBits(this.orientation) != Float.floatToIntBits(other.orientation)){
            return false;
        }
        if (!Objects.equals(this.velocity, other.velocity)){
            return false;
        }
        if (Float.floatToIntBits(this.rotation) != Float.floatToIntBits(other.rotation)){
            return false;
        }
        return true;
    }

    
    public  void applyNewOrientation(){
        if(this.velocity.length()> 0)
                this.orientation = (float) Math.atan2(-this.velocity.getX(), this.velocity.getZ());
    }

    
   
   @Override
   public String toString(){
       return "Chatacter{position =" + position +", orientation=" + orientation + "}";
   }
   
   public void update(KinematicOutput kinematicOutput, float time){
       this.velocity = kinematicOutput.getVelocity();
       this.rotation = kinematicOutput.getRotation();
       
       this.position.addVector2D(this.velocity.mulContant(time));
       this.orientation += this.rotation*time;
   }
   
   public static void main(String[] args) {
        // TODO code application logic here
    
    }
}
