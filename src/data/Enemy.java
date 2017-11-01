package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
import static helpers.Clock.*;

public class Enemy {
    private int width, height, health;
    private float speed, x, y;
    private Texture texture;
    private Tile startTile;
    private boolean first = true; // First time this is being run // Small fix
    private TileGrid grid;

    public Enemy(Texture texture, Tile startTile, TileGrid grid, int width, int height, float speed){
        this.texture = texture;
        this.startTile = startTile;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.grid = grid;
    }

    public void Update() {
        if (first)
            first = false;
        else {
            if (pathContinues())
            x += Delta() * speed;
        }
    }

    private boolean pathContinues(){
        boolean answer = true;

        Tile myTile = grid.GetTile((int) (x / 64), (int) (y / 64)); // Our actual x might be something like 700, but since our tiles are 64 we divide x with 64.
        Tile nextTile = grid.GetTile((int) (x / 64) +1, (int) (y / 64)); // 1 tile over to the right is the next tile

        if(myTile.getType() != nextTile.getType())
            answer = false;

        return answer;
    }

    public void Draw() {
        DrawQuadTex(texture, x, y, width, height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Tile getStartTile() {
        return startTile;
    }

    public void setStartTile(Tile startTile) {
        this.startTile = startTile;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public TileGrid getTileGrid(){
        return grid;
    }
}
