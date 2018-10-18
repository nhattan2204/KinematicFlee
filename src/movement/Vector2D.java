/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;

/**
 *
 * @author PhamNhatTan
 */
public class Vector2D {
    private float x;
    private float z;
  
   public boolean equals(Object obj)
    {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Vector2D other = (Vector2D) obj;
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)){
            return false;
        }
        if (Float.floatToIntBits(this.z) != Float.floatToIntBits(other.z)){
            return false;
        }
        return true;
    } 
   
    public void setX(float x) {
        this.x = x;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getZ() {
        return z;
    }

    
    public Vector2D(){
        
    }
    
    public Vector2D(float x, float z){
        this.x = x;
        this.z = z;
    }
    
   @Override
   public String toString(){
       return "Vector2D{x=" + x +", z=" + z + "}";
   }
   
   public Vector2D subVector2D (Vector2D v){
       this.setX(this.getX() - v.getX());
       this.setZ(this.getZ() - v.getZ());
       return this;
   }
   
   public Vector2D subVector2D (Vector2D v1, Vector2D v2){
       return new Vector2D(v1.getX() - v2.getX(), v1.getZ() - v2.getZ());
   }

   
   public Vector2D mulConstant(Vector2D vector2D, float constant){
       return new Vector2D(vector2D.getX()*constant, vector2D.getZ()*constant);
   }
   
   public Vector2D mulContant(float  constant){
       this.setX(this.getX()*constant);
       this.setZ(this.getZ()*constant);
       return this;
   }
   
   public double length(){
       return Math.sqrt(this.x * this.x + this.z * this.z);
   }
   
   public static Vector2D addVector2D (Vector2D v1, Vector2D v2){
       return new Vector2D(v1.getX() + v2.getX(), v1.getZ() + v2.getZ());
   }
   
   public Vector2D addVector2D(Vector2D v1){
       this.setX(this.getX() + v1.getX());
       this.setZ(this.getZ() + v1.getZ());
       return this;
   }
   
   public Vector2D normalize(){
       double length = this.length();
       this.x /= this.length();
       this.z /= this.length();
       return this;
   }
   
    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(1,2);
        Vector2D v2 = new Vector2D(3,4);
        System.out.println(v1.addVector2D(v2).toString());
        System.out.println(v1.subVector2D(v2).toString());
        System.out.println(v1.mulContant(2).toString());
        System.out.println(v1.length());
        System.out.println(v1.normalize().toString());
    }
}

