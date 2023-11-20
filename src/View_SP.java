
import Model.AnhSp;
import Model.AnhSp_Service;
import Model.ChatLieu;
import Model.ChatLieu_Service;
import Model.NhaCungCap;
import Model.NhaCungCap_Service;
import Model.SanPham;
import Model.SanPham_service;
import Model.TheLoai;
import Model.TheLoai_Service;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import utility.ShareHelper1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class View_SP extends javax.swing.JFrame {

    private final NhaCungCap_Service daoNcc = new NhaCungCap_Service();
    private final TheLoai_Service daoTheLoai = new TheLoai_Service();
    private final ChatLieu_Service daoChatLieu = new ChatLieu_Service();
    private final AnhSp_Service daoAnh = new AnhSp_Service();
    private final SanPham_service dao = new SanPham_service();
    DefaultTableModel mol = new DefaultTableModel();
    int index = 0;
    String strFind = "";

    /**
     * Creates new form NewJFrame
     */
    public View_SP() {
        initComponents();
        init();
        mol = (DefaultTableModel) tbl_Sp.getModel();
        //loadFind();
        fillComboBoxNcc();
        fillComboBoxLoai();
        fillComboBoxchatLieu();
        Load();
        fillChatlieu();
        fillNhaCC();
        filltheLoai();
//        fillComboBoxAnh();
    }

    void Load() {
        mol.setRowCount(0);
        ArrayList<SanPham> lst = dao.getAll();
        for (SanPham sp : lst) {
            mol.addRow(new Object[]{sp.getMaSp(),
                sp.getTenSp(),
                sp.getMoTa(),
                sp.getMaCC(),
                sp.getSolg(),
                sp.getDonGia(),
                sp.getNgayNhap(),
                sp.getAnh(),
                sp.gettrangThai()});
        }
    }

    void loadFind() {
        try {
            mol.setRowCount(0);
            for (SanPham sp : dao.getSP(strFind)) {
                mol.addRow(new Object[]{sp.getMaSp(),
                    sp.getTenSp(),
                    sp.getMoTa(),
                    sp.getMaCC(),
                    sp.getSolg(),
                    sp.getDonGia(),
                    sp.getNgayNhap(),
                    sp.getAnh(),
                    sp.gettrangThai()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillChatlieu() {
        DefaultTableModel mol1 = (DefaultTableModel) tbl_chatLieu.getModel();
        mol1.setRowCount(0);
        ArrayList<ChatLieu> lstCl = daoChatLieu.getall();
        for (ChatLieu cl : lstCl) {
            mol1.addRow(new Object[]{
                cl.getIDChatLieu(),
                cl.getChatLieu()
            });
        }
    }

    void fillNhaCC() {
        DefaultTableModel mol2 = (DefaultTableModel) tbl_Ncc.getModel();
        mol2.setRowCount(0);
        ArrayList<NhaCungCap> lstNcc = daoNcc.getall();
        for (NhaCungCap ncc : lstNcc) {
            mol2.addRow(new Object[]{
                ncc.getIDNhaCC(),
                ncc.getTenNhaCC(),
                ncc.getEmail(),
                ncc.getSdt(),
                ncc.getDiaChi()
            });
        }
    }

    void filltheLoai() {
        DefaultTableModel mol3 = (DefaultTableModel) tbl_theLoai.getModel();
        mol3.setRowCount(0);
        ArrayList<TheLoai> lstTl = daoTheLoai.getall();
        for (TheLoai tl : lstTl) {
            mol3.addRow(new Object[]{
                tl.getId_TheLoai(),
                tl.getTenTheloai()
            });
        }
    }

    void fillComboBoxNcc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_ncc.getModel();
        model.removeAllElements();

        List<NhaCungCap> list = daoNcc.getall();
        for (NhaCungCap ncc : list) {
            String ten = ncc.getTenNhaCC();
            if (model.getIndexOf(ten) < 0) {
                model.addElement(ten);
            }
        }
        cbo_ncc.setSelectedIndex(0);
    }

    void fillComboBoxLoai() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_loai.getModel();
        model.removeAllElements();

        List<TheLoai> list = daoTheLoai.getall();
        for (TheLoai tl : list) {
            String ten = tl.getTenTheloai();
            if (model.getIndexOf(ten) < 0) {
                model.addElement(ten);
            }
        }
        cbo_ncc.setSelectedIndex(0);
    }

    void fillComboBoxchatLieu() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_chatlieu.getModel();
        model.removeAllElements();

        List<ChatLieu> list = daoChatLieu.getall();
        for (ChatLieu cl : list) {
            String ten = cl.getChatLieu();
            if (model.getIndexOf(ten) < 0) {
                model.addElement(ten);
            }
        }
        cbo_ncc.setSelectedIndex(0);
    }

//    void fillComboBoxAnh() {
//        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_anhsp.getModel();
//        model.removeAllElements();
//
//        List<AnhSp> list = daoAnh.getall();
//        for (AnhSp a : list) {
//            String ten = a.getTenAnh();
//            if (model.getIndexOf(ten) < 0) {
//                model.addElement(ten);
//            }
//        }
//        cbo_ncc.setSelectedIndex(0);
//    }
    
//    
    public SanPham getMode() {
        SanPham sp = new SanPham();
//        NhaCungCap ncc = new NhaCungCap();
        sp.setTenSp(txt_tenSp.getText());
        sp.setMaSp(txt_maSp.getText());
//        sp.setMaAnh(cbo_anhsp.getSelectedIndex());
        sp.setAnh(lbl_anh.getToolTipText());
//        sp.setAnhQr(lbl_anhQr.getToolTipText());
        //sp.setLoai(txt_loai.getText());
        sp.setIdNcc(cbo_ncc.getSelectedIndex());
        sp.setIdChatLieu(cbo_chatlieu.getSelectedIndex());
        sp.setIdLoai(cbo_loai.getSelectedIndex());
//        sp.setMaCC(cbo_ncc.getItemAt(ncc.getIDNhaCC()));
        sp.setSolg(Integer.parseInt(txt_solg.getText()));
        sp.setDonGia(Float.parseFloat(txt_dongia.getText()));
        sp.setMoTa(txt_mota.getText());
        sp.setNgayNhap(txt_mnhaynhap.getText());
        // sp.setChatLieu(txt_cl.getText());
        if (sp.isTrangThai() == true) {
            rdo_conhang.setSelected(true);
        } else {
            rdo_hethang.setSelected(true);
        }
        return sp;
    }

    public  NhaCungCap getNhaCungCap(){
        NhaCungCap ncc= new NhaCungCap();
        ncc.setTenNhaCC(txt_tenNcc.getText());
        ncc.setDiaChi(txt_diadiemNcc.getText());
        ncc.setEmail(txt_emailNcc.getText());
        ncc.setSdt(txt_sdtNcc.getText());
        return ncc;
    }
    
    public ChatLieu getChatLieu(){
        ChatLieu cl =new ChatLieu();
        cl.setChatLieu(txt_tenChatLieu.getText());
        return cl;
    }
    public  TheLoai getLoai(){
        TheLoai tl =new TheLoai();
        tl.setTenTheloai(txt_tenTheLoai.getText());
        return tl;
    }
    
    
//    public  AnhSp getMOdel(){
//        AnhSp a = new AnhSp();
//        a.setID_anh(cbo_anhsp.getSelectedIndex());
//        a.setTenAnh(lbl_anhSp.getToolTipText());
//        a.setTenAnhQr(lbl_anhQr.getToolTipText());
//        return a;
//    }
    
    void setModel(int index) {
        SanPham sp = dao.getAll().get(index);
        txt_tenSpCC.setText(sp.getTenSp());
        txt_tenTheLoai.setText(sp.getLoai());
        txt_tenChatLieu.setText(sp.getChatLieu());
        txt_maSp.setText(sp.getMaSp());
        txt_dongia.setText(String.valueOf(sp.getDonGia()));
        txt_tenSp.setText(sp.getTenSp());
//        cbo_ncc.setSelectedIndex(sp.getIdNcc());
//        cbo_chatlieu.setSelectedIndex(sp.getIdChatLieu());
//        cbo_loai.setSelectedIndex(sp.getIdLoai());
        cbo_anhsp.setSelectedItem(sp.getAnh());
        cbo_ncc.setSelectedItem(sp.getMaCC());
        //txt_loai.setText(sp.getLoai());
        txt_mnhaynhap.setText(String.valueOf(sp.getNgayNhap()));
        txt_mota.setText(sp.getMoTa());
        //txt_cl.setText(sp.getChatLieu());
        cbo_chatlieu.setSelectedItem(sp.getChatLieu());
        cbo_loai.setSelectedItem(sp.getLoai());
        //txt_nhaCC.setText(sp.getMaCC());
        txt_solg.setText(String.valueOf(sp.getSolg()));
        lbl_anh.setToolTipText(sp.getAnh());
        if (sp.getAnh() != null) {
            lbl_anh.setIcon(ShareHelper1.readLogo(sp.getAnh()));
        }
//        lbl_anhSp.setToolTipText(sp.getAnh());
//        if (sp.getAnh() != null) {
//            lbl_anhSp.setIcon(ShareHelper1.readLogo(sp.getAnh()));
//        }
//        lbl_anhQr.setToolTipText(sp.getAnh());
//        if (sp.getAnh() != null) {
//            lbl_anhQr.setIcon(ShareHelper1.readLogo(sp.getAnh()));
//        }
        if (sp.isTrangThai() == true) {
            rdo_conhang.setSelected(true);
        } else {
            rdo_hethang.setSelected(true);
        }
    }

    void setModelNcc(int index) {
        NhaCungCap ncc = daoNcc.getall().get(index);
        txt_diadiemNcc.setText(ncc.getDiaChi());
        txt_tenNcc.setText(ncc.getTenNhaCC());
        txt_emailNcc.setText(ncc.getEmail());
        txt_sdtNcc.setText(ncc.getSdt());
        txt_idNcc.setText(String.valueOf(ncc.getIDNhaCC()));
    }

    void setModelCl(int index) {
        ChatLieu cl = daoChatLieu.getall().get(index);
        txt_tenChatLieu.setText(cl.getChatLieu());
        txt_idCl.setText(String.valueOf(cl.getIDChatLieu()));
    }

    void setMOdelTl(int index) {
        TheLoai tl = daoTheLoai.getall().get(index);
        txt_tenTheLoai.setText(tl.getTenTheloai());
        txt_idTl.setText(String.valueOf(tl.getId_TheLoai()));
    }

    private void init() {
        this.setLocationRelativeTo(null);
        setIconImage(ShareHelper1.APP_ICON);
        new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                SimpleDateFormat formater = new SimpleDateFormat("hh::mm:ss a");
                String text = formater.format(now);
                lbl_time.setText(text);
            }
        }).start();
    }

    void selectImage() {
        if (fileAnh.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileAnh.getSelectedFile();
            if (ShareHelper1.saveLogo(file)) {
                // Hiển thị hình lên form 
                
                lbl_anh.setIcon(ShareHelper1.readLogo(file.getName()));
                lbl_anh.setToolTipText(file.getName());
                
            }
        }
    }

//    void insertAnh(){
//        AnhSp mol = getMOdel();
//        try {
//            daoAnh.add(mol);
//            this.Load();
//            //this.clear();
//            JOptionPane.showMessageDialog(this, "Thêm Thành Cônng");
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Chuyên đề này đã có!");
//        }
//    }
    
    
    void insert() {
        SanPham model = getMode();
        try {
            dao.add(model);
            this.Load();
            this.clear();
            JOptionPane.showMessageDialog(this, "Thêm Thành Cônng");
            ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chuyên đề này đã có!");
        }
    }
    void delete() {
            String macd = txt_maSp.getText();
            try {
                dao.del(macd);
                this.Load();
                this.clear();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại! ");
            }
        
    }
    void update(){
         SanPham model = getMode();
            try {
                dao.update(model);
                this.Load();
                this.clear();
                JOptionPane.showMessageDialog(this, "Update thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "update thất bại! ");
            }
    }

    void insertNcc() {
        NhaCungCap modCap = getNhaCungCap();
        try {
            daoNcc.add(modCap);
            this.fillNhaCC();
            this.fillComboBoxNcc();
            this.clear();
            JOptionPane.showMessageDialog(this, "Thêm Thành Cônng");
            ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chuyên đề này đã có!");
        }
    }
    void deleteNcc() {
            String idNcc = txt_idNcc.getText();
            try {
                daoNcc.del(idNcc);
                this.fillNhaCC();
                this.fillComboBoxNcc();
                this.clear();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại! ");
            }
        
    }
    void updateNcc(){
         NhaCungCap modCap = getNhaCungCap();
            try {
                daoNcc.update(modCap);
                this.fillNhaCC();
                this.fillComboBoxNcc();
                this.clear();
                JOptionPane.showMessageDialog(this, "Update thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "update thất bại! ");
            }
    }
    
    void insertTl() {
        TheLoai mol3 = getLoai();
        try {
            daoTheLoai.add(mol3);
            this.filltheLoai();
                    this.fillComboBoxLoai();
            this.clear();
            JOptionPane.showMessageDialog(this, "Thêm Thành Cônng");
            ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chuyên đề này đã có!");
        }
    }
    void deleteTl() {
            String idNcc = txt_idTl.getText();
            try {
                daoTheLoai.del(idNcc);
                this.filltheLoai();
                this.fillComboBoxLoai();
                this.clear();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại! ");
            }
        
    }
    void updateTl(){
         TheLoai mol3 = getLoai();
            try {
                daoTheLoai.update(mol3);
                this.filltheLoai();
                this.fillComboBoxLoai();
                this.clear();
                JOptionPane.showMessageDialog(this, "Update thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "update thất bại! ");
            }
    }
    void insertCl() {
        ChatLieu mol4 = getChatLieu();
        try {
            daoChatLieu.add(mol4);
            this.fillChatlieu();
            this.fillComboBoxchatLieu();
            this.clear();
            JOptionPane.showMessageDialog(this, "Thêm Thành Cônng");
            ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chuyên đề này đã có!");
        }
    }
    void deleteCl() {
            String idNcc = txt_idCl.getText();
            try {
                daoChatLieu.del(idNcc);
                this.fillChatlieu();
                 this.fillComboBoxchatLieu();
                 this.clear();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại! ");
            }
        
    }
    void updateNccCl(){
          ChatLieu mol4 = getChatLieu();
            try {
                daoChatLieu.update(mol4);
                this.fillChatlieu();
                 this.fillComboBoxchatLieu();
                 this.clear();
                JOptionPane.showMessageDialog(this, "Update thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "update thất bại! ");
            }
    }
    
    void clear(){
        txt_diadiemNcc.setText("");
        txt_dongia.setText("");
        txt_emailNcc.setText("");
        txt_find1.setText("");
        txt_idCl.setText("");
        txt_idNcc.setText("");
        txt_idTl.setText("");
        txt_maSp.setText("");
        txt_mnhaynhap.setText("");
        txt_mota.setText("");
        txt_sdtNcc.setText("");
        txt_solg.setText("");
        txt_tenChatLieu.setText("");
        txt_tenNcc.setText("");
        txt_tenSp.setText("");
        txt_tenSpCC.setText("");
        txt_tenTheLoai.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        fileAnh = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        lbl_time = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        pnl_dsSP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Sp = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_find1 = new javax.swing.JTextField();
        btn_find1 = new javax.swing.JButton();
        cbo_Soft = new javax.swing.JComboBox<>();
        pnl_Sp = new javax.swing.JPanel();
        btn_frist = new javax.swing.JButton();
        txt_tenSp = new javax.swing.JTextField();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        txt_solg = new javax.swing.JTextField();
        txt_dongia = new javax.swing.JTextField();
        txt_mnhaynhap = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lbl_anh = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_maSp = new javax.swing.JTextField();
        btn_clear = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        rdo_conhang = new javax.swing.JRadioButton();
        rdo_hethang = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_mota = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        cbo_loai = new javax.swing.JComboBox<>();
        cbo_ncc = new javax.swing.JComboBox<>();
        cbo_chatlieu = new javax.swing.JComboBox<>();
        cbo_anhsp = new javax.swing.JComboBox<>();
        pnl_Ncc = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_tenNcc = new javax.swing.JTextField();
        txt_emailNcc = new javax.swing.JTextField();
        txt_sdtNcc = new javax.swing.JTextField();
        txt_diadiemNcc = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Ncc = new javax.swing.JTable();
        btn_addNCC = new javax.swing.JButton();
        btn_updateNcc = new javax.swing.JButton();
        btn_delNcc = new javax.swing.JButton();
        btn_clearNcc = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txt_idNcc = new javax.swing.JTextField();
        pnl_chiteit = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btb_addCl = new javax.swing.JButton();
        btn_xoaCl = new javax.swing.JButton();
        btn_updateCl = new javax.swing.JButton();
        txt_tenChatLieu = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_idCl = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btn_addTL = new javax.swing.JButton();
        btn_delTl = new javax.swing.JButton();
        btn_updeteTL = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txt_tenTheLoai = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_idTl = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_tenSpCC = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_chatLieu = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_theLoai = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666686_github.png"))); // NOI18N
        jLabel10.setText("PetShop");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666691_home.png"))); // NOI18N
        jButton10.setText("Trang chủ");

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666616_shopping_cart.png"))); // NOI18N
        jButton11.setText("Bán hàng");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666784_package_box_delivery.png"))); // NOI18N
        jButton12.setText("Sản Phẩm");

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666609_user.png"))); // NOI18N
        jButton13.setText("Nhân viên");

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666755_group_users.png"))); // NOI18N
        jButton14.setText("Khách Hàng");

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666800_up_arrow_trending.png"))); // NOI18N
        jButton15.setText("Thống kê");

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666722_in_log.png"))); // NOI18N
        jButton16.setText("Log out");

        lbl_time.setText("..");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lbl_time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addGap(18, 18, 18)
                .addComponent(jButton14)
                .addGap(18, 18, 18)
                .addComponent(jButton15)
                .addGap(26, 26, 26)
                .addComponent(jButton16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_time)
                .addGap(23, 23, 23))
        );

        tbl_Sp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sp", "Tên Sp", "Mô Tả", "Nhà cung cấp", "Số lượng", "Đơn giá", "Ngày nhập", "Ảnh", "Trạng thái"
            }
        ));
        tbl_Sp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Sp);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Tìm kiếm");

        txt_find1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_find1CaretUpdate(evt);
            }
        });

        btn_find1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666693_search.png"))); // NOI18N
        btn_find1.setText("Find");
        btn_find1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_find1ActionPerformed(evt);
            }
        });

        cbo_Soft.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_find1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_find1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbo_Soft, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_find1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_find1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbo_Soft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_dsSPLayout = new javax.swing.GroupLayout(pnl_dsSP);
        pnl_dsSP.setLayout(pnl_dsSPLayout);
        pnl_dsSPLayout.setHorizontalGroup(
            pnl_dsSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dsSPLayout.createSequentialGroup()
                .addGroup(pnl_dsSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_dsSPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(pnl_dsSPLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 194, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_dsSPLayout.setVerticalGroup(
            pnl_dsSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_dsSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        tabs.addTab("Danh Sách Sản Phẩm", pnl_dsSP);

        btn_frist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666732_back_skip.png"))); // NOI18N
        btn_frist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fristActionPerformed(evt);
            }
        });

        btn_prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666720_rewind.png"))); // NOI18N
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666560_forward_fast.png"))); // NOI18N
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666733_forward_skip.png"))); // NOI18N
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        txt_mnhaynhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mnhaynhapActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Ảnh"));

        lbl_anh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666659_image.png"))); // NOI18N
        lbl_anh.setText("...");
        lbl_anh.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_anh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_anhMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anh, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(lbl_anh, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666724_upload.png"))); // NOI18N
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666736_x_circle.png"))); // NOI18N
        btn_del.setText("Delete");
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666681_edit.png"))); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã Sản Phẩm");

        jLabel2.setText("Tên Sản Phẩm");

        jLabel3.setText("Loại");

        jLabel4.setText("Nhà cung cấp ");

        jLabel5.setText("Số lượng");

        jLabel6.setText("Đơn giá");

        jLabel7.setText("Ngày Nhập");

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666728_cw_refresh.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jLabel11.setText("Trạng thái");

        buttonGroup1.add(rdo_conhang);
        rdo_conhang.setText("Còn Hàng");

        buttonGroup1.add(rdo_hethang);
        rdo_hethang.setText("Hết hàng");

        jLabel12.setText("Mô tả");

        txt_mota.setColumns(20);
        txt_mota.setRows(5);
        jScrollPane2.setViewportView(txt_mota);

        jLabel21.setText("Chất Liệu");

        cbo_loai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_ncc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_chatlieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_anhsp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnl_SpLayout = new javax.swing.GroupLayout(pnl_Sp);
        pnl_Sp.setLayout(pnl_SpLayout);
        pnl_SpLayout.setHorizontalGroup(
            pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_SpLayout.createSequentialGroup()
                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_SpLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btn_frist, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_last))
                    .addGroup(pnl_SpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addGroup(pnl_SpLayout.createSequentialGroup()
                                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_SpLayout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                            .addComponent(txt_maSp, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_SpLayout.createSequentialGroup()
                                            .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel21))
                                            .addGap(18, 18, 18)
                                            .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cbo_chatlieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_tenSp, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                                .addComponent(cbo_loai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(pnl_SpLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbo_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(110, 110, 110)
                                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_SpLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(cbo_anhsp, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_SpLayout.createSequentialGroup()
                        .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_SpLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_solg, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_mnhaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_SpLayout.createSequentialGroup()
                                        .addComponent(rdo_conhang)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdo_hethang))))
                            .addGroup(pnl_SpLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)))
                        .addGap(21, 21, 21)
                        .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_update)
                            .addComponent(btn_add))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_del)
                            .addComponent(btn_clear))))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        pnl_SpLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_add, btn_clear, btn_del, btn_update});

        pnl_SpLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_frist, btn_last, btn_next, btn_prev});

        pnl_SpLayout.setVerticalGroup(
            pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_SpLayout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_SpLayout.createSequentialGroup()
                        .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_SpLayout.createSequentialGroup()
                                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txt_maSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_tenSp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(cbo_loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbo_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cbo_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_SpLayout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(cbo_anhsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txt_solg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(txt_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(txt_mnhaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_SpLayout.createSequentialGroup()
                        .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add)
                            .addComponent(btn_del))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_update)
                            .addComponent(btn_clear))
                        .addGap(39, 39, 39)))
                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdo_conhang)
                        .addComponent(rdo_hethang)))
                .addGap(19, 19, 19)
                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(26, 26, 26)
                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_frist)
                    .addComponent(btn_prev)
                    .addComponent(btn_next)
                    .addComponent(btn_last))
                .addGap(45, 45, 45))
        );

        pnl_SpLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_frist, btn_last, btn_next, btn_prev});

        tabs.addTab("Sản phẩm", pnl_Sp);

        jLabel8.setText("Tên Nhà Cung cấp");

        jLabel9.setText("Email");

        jLabel14.setText("Sdt");

        jLabel15.setText("Địa Điêm");

        tbl_Ncc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Tên Nhà Cung Cấp", "Email", "Sdt", "Địa Điểm"
            }
        ));
        tbl_Ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NccMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_Ncc);

        btn_addNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666724_upload.png"))); // NOI18N
        btn_addNCC.setText("ADD");
        btn_addNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addNCCActionPerformed(evt);
            }
        });

        btn_updateNcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666681_edit.png"))); // NOI18N
        btn_updateNcc.setText("Update");
        btn_updateNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateNccActionPerformed(evt);
            }
        });

        btn_delNcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666595_x.png"))); // NOI18N
        btn_delNcc.setText("Delete");
        btn_delNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delNccActionPerformed(evt);
            }
        });

        btn_clearNcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666635_ccw_refresh.png"))); // NOI18N
        btn_clearNcc.setText("Clear");
        btn_clearNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearNccActionPerformed(evt);
            }
        });

        jLabel20.setText("ID");

        txt_idNcc.setEditable(false);

        javax.swing.GroupLayout pnl_NccLayout = new javax.swing.GroupLayout(pnl_Ncc);
        pnl_Ncc.setLayout(pnl_NccLayout);
        pnl_NccLayout.setHorizontalGroup(
            pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnl_NccLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_NccLayout.createSequentialGroup()
                        .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tenNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(txt_emailNcc)
                            .addComponent(txt_sdtNcc)
                            .addComponent(txt_idNcc))
                        .addGap(61, 61, 61)
                        .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_addNCC)
                            .addComponent(btn_updateNcc))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_delNcc)
                            .addComponent(btn_clearNcc))
                        .addGap(167, 167, 167))
                    .addGroup(pnl_NccLayout.createSequentialGroup()
                        .addComponent(txt_diadiemNcc)
                        .addGap(440, 440, 440))))
        );

        pnl_NccLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_addNCC, btn_clearNcc, btn_delNcc, btn_updateNcc});

        pnl_NccLayout.setVerticalGroup(
            pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_NccLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_NccLayout.createSequentialGroup()
                        .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_addNCC)
                            .addComponent(btn_delNcc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_updateNcc)
                            .addComponent(btn_clearNcc))
                        .addGap(21, 21, 21))
                    .addGroup(pnl_NccLayout.createSequentialGroup()
                        .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txt_idNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tenNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_emailNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sdtNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_diadiemNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pnl_NccLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_addNCC, btn_clearNcc, btn_delNcc, btn_updateNcc});

        tabs.addTab("Thông tin NCC", pnl_Ncc);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setText("Chất Liệu");

        jLabel18.setText("Tên Chất liệu");

        btb_addCl.setText("Add");
        btb_addCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btb_addClActionPerformed(evt);
            }
        });

        btn_xoaCl.setText("Delete");
        btn_xoaCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaClActionPerformed(evt);
            }
        });

        btn_updateCl.setText("Update");
        btn_updateCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateClActionPerformed(evt);
            }
        });

        jLabel22.setText("ID");

        txt_idCl.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel17))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btb_addCl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoaCl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_updateCl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tenChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txt_idCl))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txt_idCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_tenChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btb_addCl)
                    .addComponent(btn_xoaCl)
                    .addComponent(btn_updateCl))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setText("Thể loại");

        btn_addTL.setText("Add");
        btn_addTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addTLActionPerformed(evt);
            }
        });

        btn_delTl.setText("Delete");
        btn_delTl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delTlActionPerformed(evt);
            }
        });

        btn_updeteTL.setText("Update");
        btn_updeteTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updeteTLActionPerformed(evt);
            }
        });

        jLabel25.setText("Tên Thể Loại");

        jLabel23.setText("ID");

        txt_idTl.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btn_addTL, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delTl, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_updeteTL, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(txt_idTl, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(txt_tenTheLoai))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel19)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txt_idTl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addTL)
                    .addComponent(btn_delTl)
                    .addComponent(btn_updeteTL))
                .addContainerGap())
        );

        jLabel16.setText("Tên Sản Phẩm");

        txt_tenSpCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_tenSpCCMousePressed(evt);
            }
        });

        tbl_chatLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Tên Chất liệu"
            }
        ));
        tbl_chatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_chatLieuMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_chatLieu);

        tbl_theLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Tên loại'"
            }
        ));
        tbl_theLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_theLoaiMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_theLoai);

        javax.swing.GroupLayout pnl_chiteitLayout = new javax.swing.GroupLayout(pnl_chiteit);
        pnl_chiteit.setLayout(pnl_chiteitLayout);
        pnl_chiteitLayout.setHorizontalGroup(
            pnl_chiteitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_chiteitLayout.createSequentialGroup()
                .addGroup(pnl_chiteitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_chiteitLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tenSpCC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnl_chiteitLayout.createSequentialGroup()
                        .addGroup(pnl_chiteitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_chiteitLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_chiteitLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(pnl_chiteitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnl_chiteitLayout.setVerticalGroup(
            pnl_chiteitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_chiteitLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnl_chiteitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_tenSpCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_chiteitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_chiteitLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                    .addGroup(pnl_chiteitLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabs.addTab("Thông tin chi tiết SP", pnl_chiteit);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(tabs)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void tbl_NccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NccMouseClicked
        index = tbl_Ncc.getSelectedRow();
        setModelNcc(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_NccMouseClicked

    private void lbl_anhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhMouseClicked
          this.selectImage();
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_anhMouseClicked

    private void txt_mnhaynhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mnhaynhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mnhaynhapActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        this.index = tbl_Sp.getRowCount();
        setModel(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        this.index++;
        setModel(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        this.index--;
        setModel(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_fristActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fristActionPerformed
        this.index = 0;
        setModel(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_fristActionPerformed

    private void tbl_theLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_theLoaiMouseClicked
        index = tbl_theLoai.getSelectedRow();
        tabs.setSelectedIndex(3);
        setMOdelTl(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_theLoaiMouseClicked

    private void btn_find1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_find1ActionPerformed
        strFind = txt_find1.getText();
        loadFind();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_find1ActionPerformed

    private void tbl_SpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SpMouseClicked
        index = tbl_Sp.getSelectedRow();
        tabs.setSelectedIndex(1);
        setModel(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_SpMouseClicked

    private void txt_tenSpCCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tenSpCCMousePressed
//        if (evt.getClickCount() == 2) {
//            new SanPham1().setVisible(true);
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenSpCCMousePressed

    private void lbl_anhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhMousePressed
//        if (evt.getClickCount() == 2) {
//            tabs.setSelectedIndex(3);
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_anhMousePressed

    private void txt_find1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_find1CaretUpdate
        strFind = txt_find1.getText();
        Load();
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_find1CaretUpdate

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        insert();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addActionPerformed

    private void tbl_chatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chatLieuMouseClicked
        // TODO add your handling code here:
        index = tbl_chatLieu.getSelectedRowCount();
        setModelCl(index);
    }//GEN-LAST:event_tbl_chatLieuMouseClicked

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
      delete();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       update();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addNCCActionPerformed
        insertNcc();
    // TODO add your handling code here:
    }//GEN-LAST:event_btn_addNCCActionPerformed

    private void btn_delNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delNccActionPerformed
      deleteNcc();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_delNccActionPerformed

    private void btn_updateNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateNccActionPerformed
       updateNcc();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateNccActionPerformed

    private void btb_addClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btb_addClActionPerformed
       insertCl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btb_addClActionPerformed

    private void btn_xoaClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaClActionPerformed
       deleteCl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xoaClActionPerformed

    private void btn_updateClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateClActionPerformed
     updateNccCl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateClActionPerformed

    private void btn_addTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addTLActionPerformed
       insertTl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addTLActionPerformed

    private void btn_delTlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delTlActionPerformed
      deleteTl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_delTlActionPerformed

    private void btn_updeteTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updeteTLActionPerformed
      updateTl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updeteTLActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
      clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_clearNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearNccActionPerformed
        clear();
// TODO add your handling code here:
    }//GEN-LAST:event_btn_clearNccActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View_SP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_SP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_SP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_SP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_SP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btb_addCl;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_addNCC;
    private javax.swing.JButton btn_addTL;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_clearNcc;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_delNcc;
    private javax.swing.JButton btn_delTl;
    private javax.swing.JButton btn_find1;
    private javax.swing.JButton btn_frist;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_updateCl;
    private javax.swing.JButton btn_updateNcc;
    private javax.swing.JButton btn_updeteTL;
    private javax.swing.JButton btn_xoaCl;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_Soft;
    private javax.swing.JComboBox<String> cbo_anhsp;
    private javax.swing.JComboBox<String> cbo_chatlieu;
    private javax.swing.JComboBox<String> cbo_loai;
    private javax.swing.JComboBox<String> cbo_ncc;
    private javax.swing.JFileChooser fileAnh;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JPanel pnl_Ncc;
    private javax.swing.JPanel pnl_Sp;
    private javax.swing.JPanel pnl_chiteit;
    private javax.swing.JPanel pnl_dsSP;
    private javax.swing.JRadioButton rdo_conhang;
    private javax.swing.JRadioButton rdo_hethang;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbl_Ncc;
    private javax.swing.JTable tbl_Sp;
    private javax.swing.JTable tbl_chatLieu;
    private javax.swing.JTable tbl_theLoai;
    private javax.swing.JTextField txt_diadiemNcc;
    private javax.swing.JTextField txt_dongia;
    private javax.swing.JTextField txt_emailNcc;
    private javax.swing.JTextField txt_find1;
    private javax.swing.JTextField txt_idCl;
    private javax.swing.JTextField txt_idNcc;
    private javax.swing.JTextField txt_idTl;
    private javax.swing.JTextField txt_maSp;
    private javax.swing.JTextField txt_mnhaynhap;
    private javax.swing.JTextArea txt_mota;
    private javax.swing.JTextField txt_sdtNcc;
    private javax.swing.JTextField txt_solg;
    private javax.swing.JTextField txt_tenChatLieu;
    private javax.swing.JTextField txt_tenNcc;
    private javax.swing.JTextField txt_tenSp;
    private javax.swing.JTextField txt_tenSpCC;
    private javax.swing.JTextField txt_tenTheLoai;
    // End of variables declaration//GEN-END:variables
}
