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
public class KinematicOutput {
    
    private Vector2D velocity;
    private float rotation;

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public float getRotation() {
        return rotation;
    }

    public KinematicOutput(){}
    
    public KinematicOutput(Vector2D velocity, float  rotation){
        this.velocity = velocity;
        this.rotation = rotation;
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
        final KinematicOutput other = (KinematicOutput) obj;
        if (Float.floatToIntBits(this.rotation) != Float.floatToIntBits(other.rotation)) {
            return false;
        }
        if (!Objects.equals(this.velocity, other.velocity)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "KinematicOutput{" + "velocity=" + velocity + ", rotation=" + rotation + '}';
    }
    
}
