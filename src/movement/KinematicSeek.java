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
public class KinematicSeek {
    private Character target;
    private float maxSpeed;
    private Character character;

    public Character getTarget() {
        return target;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public Character getCharacter() {
        return character;
    }

    public void setTarget(Character target) {
        this.target = target;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
    
    public void setMaxSpeed(float maxSpeed){
        this.maxSpeed = maxSpeed;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KinematicSeek other = (KinematicSeek) obj;
        if (Float.floatToIntBits(this.maxSpeed) != Float.floatToIntBits(other.maxSpeed)) {
            return false;
        }
        if (!Objects.equals(this.character, other.character)) {
            return false;
        }
        if (!Objects.equals(this.target, other.target)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KinematicSeek{" + "charater=" + character + ", target=" + target + ", maxSpeed=" + maxSpeed + '}';
    }
    
    public KinematicSeek(){
        
    }
    
    public KinematicSeek(Character character, float maxSpeed, Character target){
        this.character = character;
        this.maxSpeed = maxSpeed;
        this.target = target;
    }
    
    
    public KinematicOutput generateKinematicoutput(){
        Vector2D velocity = new Vector2D();
        velocity = target.getPosition().subVector2D(character.getPosition());
        velocity.normalize();
        velocity.mulContant(maxSpeed);
        
        return  new KinematicOutput(velocity, 0);
    }
    
    public static void main(String[] args) {
        Character character = new Character();
        character.setPosition(new Vector2D(2,1));
        
        Character target = new Character();
        target.setPosition(new Vector2D(9,1));
        
        KinematicSeek kinematicSeek = new KinematicSeek(character,1, target);
        KinematicOutput kinematicOutput = kinematicSeek.generateKinematicoutput();
        character.update(kinematicOutput,1);
        character.applyNewOrientation();
        
        System.out.println(character.getPosition());
        System.out.println(character.getOrientation());
    }
}
