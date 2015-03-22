package se.tube42.kidsmem.control;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

import se.tube42.lib.service.*;
import se.tube42.kidsmem.data.*;
import se.tube42.kidsmem.view.*;

import static se.tube42.kidsmem.data.Assets.*;

public class AssetHelper
{

    public static void load()
    {
        long t0 = System.currentTimeMillis();

        String base = "1/";

        // fonts
        if(UI.dpi_class > 2) {
            font1 = AssetService.loadFont(base + "font1x2");
            font1.setScale(0.5f);
        } else {
            font1 = AssetService.loadFont(base + "font1");
        }

        long t1 = System.currentTimeMillis();


        // patches
        np_shadow = AssetService.loadPatch(base + "shadow.9.png", 6, 5, 6, 5);
        np_botshadow = AssetService.loadPatch(base + "botshadow.9.png", 7, 7, 1, 11);

        // Textures
        tex_candy2 = AssetService.load(base + "candy2.png", true);

        tex_menu = AssetService.load(base + "menu.png", true);
        tex_menu_shadow = AssetService.load(base + "shadow.png", true);

        tex_candy1 = AssetService.load(base + "candy1.png", true);
        tex_tiles = AssetService.load(base + "tiles.png", true);

        // regions
        reg_candy2 = AssetService.divide(tex_candy2, 256 / 6, 64);

        reg_menu = AssetService.divide(tex_menu, 128, 128);
        reg_menu_shadow = AssetService.divide(tex_menu_shadow, 128, 128);
        reg_candy1 = AssetService.divide(tex_candy1, 102, 102);
        reg_tiles = AssetService.divide(tex_tiles, 128, 128);

        Texture tmp = AssetService.load(base + "rect.png", false);
        reg_rect = AssetService.divide(tmp, 8, 8);

        // particles
        pep_explode = AssetService.loadParticle(base, "explode");
        pep_firework = AssetService.loadParticle(base, "firework");
        pep_trail = AssetService.loadParticle(base, "trail");

        long t2 = System.currentTimeMillis();

        // audio
        sound_yes = ServiceProvider.loadSoundArray("yes");
        sound_no  = ServiceProvider.loadSoundArray("no");
        sound_hit  = ServiceProvider.loadSoundArray("hit");
        sound_start = ServiceProvider.loadSound("start");
        sound_end = ServiceProvider.loadSound("end");
        talk_on = ServiceProvider.loadSound("talk_on");
        talk_off = ServiceProvider.loadSound("talk_off");
        talk_play = ServiceProvider.loadSound("talk_play");
        talk_hardness = ServiceProvider.loadSoundArray("talk_hardness");

        
        // shaders
        shader_col2 = AssetService.loadShader("shaders/col2.vertex", "shaders/col2.fragment");
        
        
        long t3 = System.currentTimeMillis();

        System.out.println("LOADED: fonts: "  + (t1 - t0) + " textures: " + (t2 - t1) + " sounds: " + (t3 - t2));

    }
}