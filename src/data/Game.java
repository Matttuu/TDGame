package data;

import static helpers.Artist.QuickLoad;

public class Game {

    private TileGrid grid;
    private Player player;
    private Wave wave;

    //Temp Variables
    TowerCannon tower;


    public Game(int[][] map) {
        grid = new TileGrid(map);
        player = new Player(grid);
        wave = new Wave(20, new Enemy(QuickLoad("UFO64"), grid.GetTile(10,8), grid,64,64, 5));

        tower = new TowerCannon(QuickLoad("cannonBase"), grid.GetTile(14, 7), 10);
    }
    public void update(){
        grid.Draw();
        wave.Update();
        player.Update();

        tower.update();


    }
}