package game.ui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Button {

    private String content;
    private IClickPerformed iClickPerformed;
    private float x;
    private float y;
    private Color normal = Color.orange;
    private Color hover = Color.yellow;
    private Color active = Color.red;
    private Color current = normal;

    public Button(String content) {
        this.content = content;
    }

    public Button(float x, float y, String content) {
        this(content);
        this.x = x;
        this.y = y;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Color getNormal() {
        return normal;
    }

    public void setNormal(Color normal) {
        this.normal = normal;
    }

    public Color getHover() {
        return hover;
    }

    public void setHover(Color hover) {
        this.hover = hover;
    }

    public Color getActive() {
        return active;
    }

    public void setActive(Color active) {
        this.active = active;
    }

    public Color getCurrent() {
        return current;
    }

    public void setCurrent(Color current) {
        this.current = current;
    }

    public void setClickPerformed(IClickPerformed iClickPerformed) {
        this.iClickPerformed = iClickPerformed;
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        Color c = g.getColor();
        g.setColor(current);
        g.drawString(content, x, y);
        g.setColor(c);
    }

    public void update(GameContainer gc) throws SlickException {
        if (Mouse.getX() > x
                && Mouse.getX() < x + gc.getDefaultFont().getWidth(content)
                && (gc.getHeight() - Mouse.getY()) > y
                && (gc.getHeight() - Mouse.getY()) < y + gc.getDefaultFont().getHeight(content)) {
            current = hover;
            if (Mouse.isButtonDown(0)) {
                current = active;
                if(iClickPerformed != null){
                    iClickPerformed.click();
                }
            }
        } else {
            current = normal;
        }

    }

    public static interface IClickPerformed {
        public abstract void click();
    }
}
