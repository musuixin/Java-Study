package top.musuixin.p2p.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author musuixin
 */
@Data
public class Message implements Serializable {
    private int id;
    private String content;

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }
}
