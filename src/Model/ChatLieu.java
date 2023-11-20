/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class ChatLieu {
    private int IDChatLieu ;
    private String ChatLieu;

    public ChatLieu() {
    }

    public ChatLieu(int IDChatLieu, String ChatLieu) {
        this.IDChatLieu = IDChatLieu;
        this.ChatLieu = ChatLieu;
    }

    public int getIDChatLieu() {
        return IDChatLieu;
    }

    public void setIDChatLieu(int IDChatLieu) {
        this.IDChatLieu = IDChatLieu;
    }

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String ChatLieu) {
        this.ChatLieu = ChatLieu;
    }
    
}
