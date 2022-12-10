/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pvt.oumarket;

import static com.pvt.oumarket.FLoginController.username;
import com.pvt.pojo.ChiNhanh;
import com.pvt.pojo.ChiTietHoaDon;
import com.pvt.pojo.ChucVu;
import com.pvt.pojo.HangHoa;
import com.pvt.pojo.HoaDon;
import com.pvt.pojo.KhachHang;
import com.pvt.pojo.KhuyenMai;
import com.pvt.pojo.NhanVien;
import com.pvt.pojo.QuanLyHang;
import com.pvt.services.ChiNhanhServices;
import com.pvt.services.ChiTietHoaDonServices;
import com.pvt.services.ChucVuServices;
import com.pvt.services.HangHoaServices;
import com.pvt.services.HoaDonServices;
import com.pvt.services.KhachHangServices;
import com.pvt.services.KhuyenMaiServices;
import com.pvt.services.NhanVienServices;
import com.pvt.services.QuanLyHangServices;
import com.pvt.services.UserServices;
import com.pvt.utils.Utils;
import java.io.IOException;
import java.net.URL;
import java.security.interfaces.RSAKey;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.time.ZoneId;
import java.util.List;
/**
 * FXML Controller class
 *
 * @author tien
 */
public class FHomeController implements Initializable {
    public float totalvalue;
    private LocalDate dateThamGia = LocalDate.now();
    /**
     * Initializes the controller class.
     */
    @FXML private Label lbStatus;
    @FXML private Tab tabNhanVien;
    @FXML private Tab tabChiNhanh;
    
    /*
    Chi nhánh
    */
    @FXML private TextField txttenchinhanh;
    @FXML private TextField txtdiachi;
    @FXML private TextField txtMaCN;
    @FXML private TableView tbChiNhanh;
    @FXML private TextField keyWordCN;
    @FXML private ComboBox<ChiNhanh> cbCN;
    
    /*
    Hàng hóa
    */
    @FXML private TextField txtMaHH;
    @FXML private TextField txtTenHH;
    @FXML private TextField txtXuatXu;
    @FXML private TextField txtDonGia;
    @FXML private TableView tbHangHoa;
    @FXML private TextField keyWordHH;
    @FXML private ComboBox<HangHoa> cbHH;
    /*
    Nhân viên
    */
    @FXML private TextField txtMaNV;
    @FXML private TextField txtTenNV;
    @FXML private DatePicker ngayBatDau;
    @FXML private DatePicker ngayKetThuc;
    @FXML private TextField txtSDT;
    @FXML private TextField txtCMND;
    @FXML private TextField txtMaCV_user;
    @FXML private TextField txtMaCN_user;
    @FXML private TextField txtLuong;
    @FXML private TextField txtMaTK_user;
    @FXML private TableView tbNhanVien;
    @FXML private TextField keyWordNV;
    
    
    /*
    Khuyến mãi
    */
    @FXML private TextField txtMaHHKhuyenMai;
    @FXML private DatePicker txtNgayBDKM;
    @FXML private DatePicker txtNgayKTKM;
    @FXML private TextField txtGiaKM;
    @FXML private TableView tbKhuyenMai;
    @FXML private TextField keyWordKM;
    
    /*
    Chi tiết hóa đơn
    */
    @FXML private TextField txtMaHD;
    @FXML private TextField txtMaHH_HD;
    @FXML private TextField txtSoLuongHH_HD;
    @FXML private TextField txtTongTien_HD;
    @FXML private TextField txtTienNhan_HD;
    @FXML private TextField txtMaKH_HD;
    @FXML private TextField txtMaCN_HD;
    @FXML private TableView tbChiTietHoaDon;
    @FXML private Button btnThemHH_HD;
    @FXML private Button btnCapNhatHH_HD;
    @FXML private Button btnXoaHH_HD;
    @FXML private Button btnLuuHD;
    @FXML private Button btnTaoHD;
    public int userroleID; 
    public int day = Calendar.getInstance().get(Calendar.DATE);
    public int month = Calendar.getInstance().get(Calendar.MONTH)+1;
    public int userid;
    public void getThisId(int id){
        this.userid = id;
    }
    
//    Khách hàng
    @FXML private TextField txtMaKH;
    @FXML private TextField txtTenKH;
    @FXML private DatePicker txtNgaySinhKH;
    @FXML private TextField txtSDTKH;
    @FXML private TextField txtCMNDKH;
    @FXML private TableView tbKhachHang;
    @FXML private TextField keyWordKH;
    
    /*
    Quản lý hàng hóa
    */
    @FXML private TextField txtQuantity;
    @FXML private TableView tbQLHH;
    
    /*
    Xử lý hàm
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Platform.runLater(()-> {
        HangHoaServices hsv = new HangHoaServices();
        ChucVuServices s = new ChucVuServices();
        ChiNhanhServices cn = new ChiNhanhServices();
        NhanVienServices nsv = new NhanVienServices();
        KhuyenMaiServices ksv = new KhuyenMaiServices();
        UserServices usv = new UserServices();
        ChiTietHoaDon ctsv = new ChiTietHoaDon();
        HoaDonServices hdsv = new HoaDonServices();
        try {
            
            lbStatus.setText("Welcome, "+ usv.getUserName(userid));
//            NhanVienTab.setDisable(true);
//            ChiNhanhTab.setDisable(true);
        } catch (Exception ex) {
            Logger.getLogger(FHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                userroleID = usv.getIdUserRole(userid);
            } catch (SQLException ex) {
                Utils.showBox("Get userrole id fail", Alert.AlertType.WARNING).show();
            }
        if (userroleID != 1)
        {
            tabNhanVien.setDisable(true);
            tabChiNhanh.setDisable(true);
        }


        
        MouseClickTBVNhanVien();
        MouseClickTBVChiNhanh();
        MouseClickTBVHangHoa();
        MouseClickTBVKhuyenMai();
        MouseClickTBVCTHD();
        MouseClickTBVKhachHang();
        
        loadTableViewChiNhanh();
        loadTableViewNhanVien();
        loadTableViewHangHoa();
        loadTableViewKhuyenMai();
        loadTableViewChiTietHoaDon();
        loadTableViewKhachHang();
        loadTableViewQuanLyHang();
        
        
        try {
            this.loadTableCN(null);
            this.loadTableNV(null);
            this.loadTableHH(null);
            this.loadTableKM(null);
            this.loadTableKH(null);
            this.loadCombobox();
            this.loadTableQLHH();
            
        } catch (SQLException ex) {
            Logger.getLogger(FHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.keyWordCN.textProperty().addListener((evt)->{
            try {
                this.loadTableCN(this.keyWordCN.getText());
            } catch (SQLException ex) {
                Logger.getLogger(FHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.keyWordHH.textProperty().addListener((evt)->{
            try {
                this.loadTableHH(this.keyWordHH.getText());
            } catch (SQLException ex) {
                Logger.getLogger(FHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.keyWordNV.textProperty().addListener((evt)->{
            try {
                this.loadTableNV(this.keyWordNV.getText());
            } catch (SQLException ex) {
                Logger.getLogger(FHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.keyWordKM.textProperty().addListener((evt)->{
            try {
                this.loadTableKM(this.keyWordKM.getText());
            } catch (SQLException ex) {
                Logger.getLogger(FHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.keyWordKH.textProperty().addListener((evt)->{
            try {
                this.loadTableKH(this.keyWordKH.getText());
            } catch (SQLException ex) {
                Logger.getLogger(FHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    });
      
    }
    public void Exit(ActionEvent event)throws SQLException{
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Bạn chuẩn bị thoát chương trình");
        alert.setContentText("Bạn có muốn thoát chương trình? (Vui lòng đăng xuất trước khi thoát chương trình");
        if (alert.showAndWait().get() == ButtonType.OK){
            UserServices usv = new UserServices();
            try{
                usv.XoaLoginUser();
            }catch(SQLException ex){
                Utils.showBox("Unknown Error!", Alert.AlertType.WARNING).show();     
            }
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
    public void LogOut(ActionEvent event)throws Exception{
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Log out");
        alert.setHeaderText("Bạn chuẩn bị đăng xuất");
        alert.setContentText("Bạn có muốn đăng xuất?");
        if (alert.showAndWait().get() == ButtonType.OK){
            UserServices usv = new UserServices();
            try{
                usv.XoaLoginUser();
            }catch(SQLException ex){
                Utils.showBox("Unknown Error!", Alert.AlertType.WARNING).show();     
            }
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FLogin.fxml"));
            Parent d = loader.load();
            Scene scene = new Scene(d);
            stage.setScene(scene);
            stage.setTitle("OUMarket - Login page");
            Image image = new Image("/com.pvt.pictures/OUMarket.png");
            stage.getIcons().add(image);
        }
    }
    
 //Chi nhánh
       public void addChiNhanh(ActionEvent event) throws SQLException{
        ChiNhanh cn = new ChiNhanh();
        if (txtMaCN.getText().matches("[0-9]") && txttenchinhanh.getText().length()>0 && txtdiachi.getText().length()>0)
        {
            cn.setId(Integer.parseInt(txtMaCN.getText()));
            cn.setTenChiNhanh(txttenchinhanh.getText());
            cn.setDiaChi(txtdiachi.getText());
            try {
            ChiNhanhServices s = new ChiNhanhServices();
            s.ThemChiNhanh(cn);             
//            Utils.showBox("Add chi nhanh succesful!", Alert.AlertType.INFORMATION).show();
            this.loadTableCN(null);
            this.txtMaCN.setText(null);
            this.txttenchinhanh.setText(null);
            this.txtdiachi.setText(null);
        } catch (SQLException ex) {
            Utils.showBox("Thêm chi nhánh không thành công!", Alert.AlertType.WARNING).show();
        } 
        }else
        {
            Utils.showBox("Vui lòng nhập đúng định dạng!", Alert.AlertType.WARNING).show();
        }
          
    }
        private void MouseClickTBVChiNhanh(){
              tbChiNhanh.setRowFactory((tbv) -> {
                  TableRow<ChiNhanh> rowChiNhanh = new TableRow<>();
                  rowChiNhanh.setOnMouseClicked((event) -> {
                    if(event.getClickCount() != 0 && (!rowChiNhanh.isEmpty())){
                      ChiNhanh rowData = rowChiNhanh.getItem();
                      this.txtMaCN.clear();
                      this.txtMaCN.appendText(String.valueOf(rowData.getId()));
                      this.txttenchinhanh.clear();
                      this.txttenchinhanh.appendText(String.valueOf(rowData.getTenChiNhanh()));
                      this.txtdiachi.clear();
                      this.txtdiachi.appendText(String.valueOf(rowData.getDiaChi()));
            };
        });
                  return rowChiNhanh;
              });
 }
        public void CapNhatChiNhanh(ActionEvent event) throws SQLException{
           ChiNhanh newcn = new ChiNhanh();
           if (txtMaCN.getText().matches("[0-9]") && txttenchinhanh.getText().length()>0 && txtdiachi.getText().length()>0)
           {
            try{
                ChiNhanhServices sv = new ChiNhanhServices();
                 ChiNhanh cn = (ChiNhanh) tbChiNhanh.getSelectionModel().getSelectedItem();
                 newcn.setId(Integer.parseInt(txtMaCN.getText()));
                 newcn.setTenChiNhanh(txttenchinhanh.getText());
                 newcn.setDiaChi(txtdiachi.getText());
                 sv.CapNhatChiNhanh(newcn);
                 this.loadTableCN(null);
                 
                 txtMaCN.clear();
                 txttenchinhanh.clear();
                 txtdiachi.clear();
           }catch (SQLException ex) {
            Utils.showBox("Cập nhật chi nhánh không thành công!", Alert.AlertType.WARNING).show();
                }
           }else
           {
               Utils.showBox("Vui lòng nhập đúng định dạng!", Alert.AlertType.WARNING).show();
           }
        }
       
       public void xoaChiNhanhHandler(ActionEvent event) throws SQLException{
        if (txtMaCN.getText().matches("[0-9]") && txttenchinhanh.getText().length()>0 && txtdiachi.getText().length()>0)
        {
         try{
            ChiNhanhServices sv = new ChiNhanhServices();
            ChiNhanh cn = (ChiNhanh) tbChiNhanh.getSelectionModel().getSelectedItem();
            sv.XoaChiNhanh(cn);
            this.loadTableCN(null);
            
            txtMaCN.clear();
            txttenchinhanh.clear();
            txtdiachi.clear();
         }catch(SQLException ex){
                Utils.showBox("Xóa chi nhánh không thành công!", Alert.AlertType.WARNING).show();
            }
        }
         else{
                 Utils.showBox("Chọn chi nhánh trước!", Alert.AlertType.WARNING).show();
                 }
       }

       private void loadTableViewChiNhanh(){
        TableColumn colIdCN = new TableColumn("Id chi nhánh");
        colIdCN.setCellValueFactory(new PropertyValueFactory("id"));
        colIdCN.setPrefWidth(100);
        TableColumn colTenCN = new TableColumn("Tên chi nhánh");
        colTenCN.setCellValueFactory(new PropertyValueFactory("tenChiNhanh"));
        colTenCN.setPrefWidth(150);
        
        
        TableColumn colDiaChi =  new TableColumn("Địa chỉ");
        colDiaChi.setCellValueFactory(new PropertyValueFactory("diaChi"));
        colDiaChi.setPrefWidth(250);
        
        this.tbChiNhanh.getColumns().addAll(colIdCN, colTenCN, colDiaChi);
    }
       //Hàng hóa
    public void addHangHoa(ActionEvent event) throws SQLException{
        HangHoa hh = new HangHoa();
        if(txtXuatXu.getText().length()>0 && txtDonGia.getText().length()>0 && Integer.parseInt(txtDonGia.getText())>0)
        {
//        hh.setId(Integer.parseInt(txtMaHH.getText()));
        hh.setTenHangHoa(txtTenHH.getText());
        hh.setXuatXu(txtXuatXu.getText());
        hh.setDonGia(Integer.parseInt(txtDonGia.getText()));
        try {
            HangHoaServices hs = new HangHoaServices();
            hs.ThemHangHoa(hh);
            this.loadTableHH(null);
            this.loadTableCN(null);
//            this.txtMaHH.setText(null);
            this.txtTenHH.setText(null);
            this.txtXuatXu.setText(null);
            this.txtDonGia.setText(null);

        } catch (SQLException ex) {
            Utils.showBox("Thêm hàng hóa thất bại!", Alert.AlertType.WARNING).show();
        } 
        }else
        {
           Utils.showBox("Nhập sai định dạng", Alert.AlertType.WARNING).show();
        }
          
    }
    private void MouseClickTBVHangHoa(){
              tbHangHoa.setRowFactory((tbv) -> {
                  TableRow<HangHoa> rowHoangHoa = new TableRow<>();
                  rowHoangHoa.setOnMouseClicked((event) -> {
                    if(event.getClickCount() != 0 && (!rowHoangHoa.isEmpty())){
                      HangHoa rowData = rowHoangHoa.getItem();
                      this.txtMaHH.clear();
                      this.txtMaHH.appendText(String.valueOf(rowData.getId()));
                      this.txtTenHH.clear();
                      this.txtTenHH.appendText(String.valueOf(rowData.getTenHangHoa()));
                      this.txtXuatXu.clear();
                      this.txtXuatXu.appendText(String.valueOf(rowData.getXuatXu()));
                      this.txtDonGia.clear();
                      this.txtDonGia.appendText(String.valueOf(rowData.getDonGia()));
            };
        });
                  return rowHoangHoa;
              });
        }
    
    private void MouseClickTBVKhachHang(){
              tbKhachHang.setRowFactory((tbv) -> {
                  TableRow<KhachHang> rowKH = new TableRow<>();
                  rowKH.setOnMouseClicked((event) -> {
                    if(event.getClickCount() != 0 && (!rowKH.isEmpty())){
                      KhachHang rowData = rowKH.getItem();
                      this.txtMaKH.clear();
                      this.txtMaKH.appendText(String.valueOf(rowData.getId()));
                      this.txtTenKH.clear();
                      this.txtTenKH.appendText(String.valueOf(rowData.getTenKH()));
                      this.txtNgaySinhKH.setValue(null);
                      this.txtNgaySinhKH.setValue((LocalDate)rowData.getNgaySinh().toLocalDate());
                      this.txtSDTKH.clear();
                      this.txtSDTKH.appendText(String.valueOf(rowData.getSDT()));
                      this.txtCMNDKH.clear();
                      this.txtCMNDKH.appendText(String.valueOf(rowData.getCmnd()));
            };
        });
                  return rowKH;
              });
        }
    private void loadTableViewHangHoa(){
        TableColumn colIdHH = new TableColumn("Id hàng hóa");
        colIdHH.setCellValueFactory(new PropertyValueFactory("id"));
        colIdHH.setPrefWidth(100);

        TableColumn colTenHH = new TableColumn("Tên hàng hóa");
        colTenHH.setCellValueFactory(new PropertyValueFactory("tenHangHoa"));
        colTenHH.setPrefWidth(100);


        TableColumn colXuatXu =  new TableColumn("Xuất xứ");
        colXuatXu.setCellValueFactory(new PropertyValueFactory("xuatXu"));
        colXuatXu.setPrefWidth(150);

        TableColumn colDonGia =  new TableColumn("Đơn giá");
        colDonGia.setCellValueFactory(new PropertyValueFactory("donGia"));
        colDonGia.setPrefWidth(150);

        this.tbHangHoa.getColumns().addAll(colIdHH, colTenHH, colXuatXu, colDonGia);
    }
    private void loadTableViewKhachHang(){
        TableColumn colIdKH = new TableColumn("Id khách hàng");
        colIdKH.setCellValueFactory(new PropertyValueFactory("id"));
        colIdKH.setPrefWidth(100);

        TableColumn colTenKH = new TableColumn("Tên khách hàng");
        colTenKH.setCellValueFactory(new PropertyValueFactory("tenKH"));
        colTenKH.setPrefWidth(100);


        TableColumn colNgaySinh =  new TableColumn("Ngày sinh");
        colNgaySinh.setCellValueFactory(new PropertyValueFactory("ngaySinh"));
        colNgaySinh.setPrefWidth(150);

        TableColumn colSDT =  new TableColumn("So dien thoai");
        colSDT.setCellValueFactory(new PropertyValueFactory("soDienThoai"));
        colSDT.setPrefWidth(150);
        
        TableColumn colCMND =  new TableColumn("CMND");
        colCMND.setCellValueFactory(new PropertyValueFactory("cmnd"));
        colCMND.setPrefWidth(150);

        this.tbKhachHang.getColumns().addAll(colIdKH, colTenKH, colNgaySinh, colSDT, colCMND);
    }
    private void loadTableViewQuanLyHang(){
        TableColumn colIdHH = new TableColumn("Mã hàng hóa");
        colIdHH.setCellValueFactory(new PropertyValueFactory("maHangHoa"));
        colIdHH.setPrefWidth(100);

        TableColumn colIdCN = new TableColumn("Mã chi nhánh");
        colIdCN.setCellValueFactory(new PropertyValueFactory("maChiNhanh"));
        colIdCN.setPrefWidth(100);


        TableColumn colSoLuongHH =  new TableColumn("Số lượng");
        colSoLuongHH.setCellValueFactory(new PropertyValueFactory("soLuong"));
        colSoLuongHH.setPrefWidth(150);

        

        this.tbQLHH.getColumns().addAll(colIdHH, colIdCN, colSoLuongHH);
    }
    public void xoaHangHoaHandler(ActionEvent event) throws SQLException{
        if(txtMaHH.getText().length() > 0 && txtMaHH.getText().length() > 0 &&
                    txtXuatXu.getText().length()>0 && txtDonGia.getText().length()>0 && Integer.parseInt(txtDonGia.getText())>0)
            {
             try{
                HangHoaServices hhsv = new HangHoaServices();
                HangHoa hh = (HangHoa) tbHangHoa.getSelectionModel().getSelectedItem();
                hhsv.xoaHangHoa(hh);
                this.loadTableHH(null);
                    txtMaHH.clear();
                     txtTenHH.clear();
                     txtXuatXu.clear();
                     txtDonGia.clear();
             }catch(SQLException ex){
                    Utils.showBox("Xóa hàng hóa thất bại!", Alert.AlertType.WARNING).show();
           }
        }
        else
        {
            Utils.showBox("Chọn hàng hóa trước!", Alert.AlertType.WARNING).show();
        }
    }
    public void CapNhatHangHoa(ActionEvent event) throws SQLException{
        HangHoa newhh = new HangHoa();
        if(txtMaHH.getText().length() > 0 && txtMaHH.getText().length() > 0 &&
                txtXuatXu.getText().length()>0 && txtDonGia.getText().length()>0&&Integer.parseInt(txtDonGia.getText())>0)
        {
            try{
                HangHoaServices hhsv = new HangHoaServices();
                HangHoa hv = (HangHoa) tbHangHoa.getSelectionModel().getSelectedItem();
                newhh.setId(Integer.parseInt(txtMaHH.getText()));
                newhh.setTenHangHoa(txtTenHH.getText());
                newhh.setXuatXu(txtXuatXu.getText());
                newhh.setDonGia(Integer.parseInt(txtDonGia.getText()));

                hhsv.suaHangHoa(newhh);
                 this.loadTableHH(null);

                 txtMaHH.clear();
                 txtTenHH.clear();
                 txtXuatXu.clear();
                 txtDonGia.clear();
           }catch(SQLException ex){
                Utils.showBox("Cập nhật hàng hóa thất bại!", Alert.AlertType.WARNING).show();
            }
        }
        else
        {
            Utils.showBox("Nhập sai định dạng!", Alert.AlertType.WARNING).show();
       }
    }
    
    //Nhân viên
    public void addNhanVien(ActionEvent event) throws SQLException, IOException{
        NhanVien nv = new NhanVien();
        if (txtMaNV.getText().matches("[0-9]")&& (txtTenNV.getText().length()>0)&&
                ngayBatDau.getValue().toString()!=null && ngayKetThuc.getValue().toString()!=null &&
                 (txtCMND.getText().length()>0)
                && (txtMaCV_user.getText().matches("[0-9]"))&& (txtMaCN_user.getText().matches("[0-9]")) &&
                (txtLuong.getText().length()>0) && txtMaTK_user.getText().matches("[0-9]"))
        {
            nv.setId(Integer.parseInt(txtMaNV.getText()));
            nv.setHoTen(txtTenNV.getText());
            nv.setNgayBatDau(java.sql.Date.valueOf(ngayBatDau.getValue()));
            nv.setNgayKetThuc(java.sql.Date.valueOf(ngayKetThuc.getValue()));
            nv.setSdt(txtSDT.getText());
            nv.setCmnd(txtCMND.getText());
            nv.setMaChucVu(Integer.parseInt(txtMaCV_user.getText()));
            nv.setMaChiNhanh(Integer.parseInt(txtMaCN_user.getText()));
            nv.setTienLuong(Integer.parseInt(txtLuong.getText()));
            nv.setMaTK(Integer.parseInt(txtMaTK_user.getText()));

            try {
                NhanVienServices nsv = new NhanVienServices();
                nsv.ThemNhanVien(nv);

                this.loadTableNV(null);
                this.txtMaNV.setText(null);
                this.txtTenNV.setText(null);
                this.ngayBatDau.setValue(null);
                this.ngayKetThuc.setValue(null);
                this.txtSDT.setText(null);
                this.txtCMND.setText(null);
                this.txtMaCV_user.setText(null);
                this.txtMaCN_user.setText(null);
                this.txtLuong.setText(null);
                this.txtMaTK_user.setText(null);
            } catch (SQLException ex) {
                Utils.showBox("Add nhân viên thất bại!", Alert.AlertType.WARNING).show();
            } 
        }
        else{
            Utils.showBox("Nhập sai định dạng!", Alert.AlertType.WARNING).show();
        }
    }
    private void MouseClickTBVNhanVien(){
              tbNhanVien.setRowFactory((tbv) -> {
                  TableRow<NhanVien> rowNhanVien = new TableRow<>();
                  rowNhanVien.setOnMouseClicked((event) -> {
                    if(event.getClickCount() != 0 && (!rowNhanVien.isEmpty())){
                      NhanVien rowData = rowNhanVien.getItem();
                      this.txtMaNV.clear();
                      this.txtMaNV.appendText(String.valueOf(rowData.getId()));
                      this.txtTenNV.clear();
                      this.txtTenNV.appendText(String.valueOf(rowData.getHoTen()));
                      this.ngayBatDau.setValue(null);
                      this.ngayBatDau.setValue((LocalDate)rowData.getNgayBatDau().toLocalDate());
                      this.ngayKetThuc.setValue(null);
                      this.ngayKetThuc.setValue((LocalDate)rowData.getNgayKetThuc().toLocalDate());                
                      this.txtSDT.clear();
                      this.txtSDT.appendText(String.valueOf(rowData.getSdt()));
                      this.txtCMND.clear();
                      this.txtCMND.appendText(String.valueOf(rowData.getCmnd()));
                      this.txtMaCN_user.clear();
                      this.txtMaCN_user.appendText(String.valueOf(rowData.getMaChiNhanh()));
                      this.txtMaCV_user.clear();
                      this.txtMaCV_user.appendText(String.valueOf(rowData.getMaChucVu()));
                      this.txtLuong.clear();
                      this.txtLuong.appendText(String.valueOf(rowData.getTienLuong()));
                      this.txtMaTK_user.clear();
                      this.txtMaTK_user.appendText(String.valueOf(rowData.getMaTK()));
            };
        });
                  return rowNhanVien;
              });
 }
        public void CapNhatNhanVien(ActionEvent event) throws SQLException{
           NhanVien newnv = new NhanVien();
           if (txtMaNV.getText().matches("[0-9]")&& (txtTenNV.getText().length()>0)&&
                ngayBatDau.getValue().toString()!=null && ngayKetThuc.getValue().toString()!=null &&
                 (txtCMND.getText().length()>0)
                && (txtMaCV_user.getText().matches("[0-9]"))&& (txtMaCN_user.getText().matches("[0-9]")) &&
                (txtLuong.getText().length()>0) && txtMaTK_user.getText().matches("[0-9]"))
           {
            try{
                NhanVienServices nsv = new NhanVienServices();
                 NhanVien nv = (NhanVien)tbNhanVien.getSelectionModel().getSelectedItem();
                 newnv.setId(Integer.parseInt(txtMaNV.getText()));
                 newnv.setHoTen(txtTenNV.getText());
                 newnv.setNgayBatDau(java.sql.Date.valueOf(ngayKetThuc.getValue()));
                 newnv.setNgayKetThuc(java.sql.Date.valueOf(ngayKetThuc.getValue()));
                 newnv.setSdt(txtSDT.getText());
                 newnv.setCmnd(txtCMND.getText());
                 newnv.setMaChucVu(Integer.parseInt(txtMaCV_user.getText()));
                 newnv.setMaChiNhanh(Integer.parseInt(txtMaCN_user.getText()));
                 newnv.setTienLuong(Integer.parseInt(txtLuong.getText()));
                 newnv.setMaTK(Integer.parseInt(txtMaTK_user.getText()));
                 
                 nsv.updateNhanVien(newnv);
                 this.loadTableNV(null);
                 
                this.txtMaNV.clear();
                 this.txtTenNV.clear();
                 this.ngayBatDau.setValue(null);
                 this.ngayKetThuc.setValue(null);
                 this.txtSDT.clear();
                 this.txtCMND.clear();
                 this.txtMaCN_user.clear();
                 this.txtMaCV_user.clear();
                 this.txtLuong.clear();
                 this.txtMaTK_user.clear();
           }catch(SQLException ex){
                Utils.showBox("Cập nhật nhân viên thất bại!", Alert.AlertType.WARNING).show();
                }
            }else
           {
               Utils.showBox("Nhập sai định dạng!", Alert.AlertType.WARNING).show();
           }
        }
       
       public void xoaNhanVienHandler(ActionEvent event) throws SQLException{
           if (txtMaNV.getText().matches("[0-9]")&& (txtTenNV.getText().length()>0)&&
                ngayBatDau.getValue().toString()!=null && ngayKetThuc.getValue().toString()!=null &&
                 (txtCMND.getText().length()>0)
                && (txtMaCV_user.getText().matches("[0-9]"))&& (txtMaCN_user.getText().matches("[0-9]")) &&
                (txtLuong.getText().length()>0) && txtMaTK_user.getText().matches("[0-9]"))
           {
            try{
               NhanVienServices sv = new NhanVienServices();
               NhanVien nv = (NhanVien) tbNhanVien.getSelectionModel().getSelectedItem();
               sv.XoaNhanVien(nv);
               this.loadTableNV(null);

                   this.txtMaNV.clear();
                    this.txtTenNV.clear();
                    this.ngayBatDau.setValue(null);
                    this.ngayKetThuc.setValue(null);
                    this.txtSDT.clear();
                    this.txtCMND.clear();
                    this.txtMaCN_user.clear();
                    this.txtMaCV_user.clear();
                    this.txtLuong.clear();
                    this.txtMaTK_user.clear();
            }catch(SQLException ex){
                   Utils.showBox("Xóa nhân viên thất bại!", Alert.AlertType.WARNING).show();
          }
           }else
           {
               Utils.showBox("Chọn nhân viên trước!", Alert.AlertType.WARNING).show();
           }
    }
    public void loadTableViewNhanVien(){
        TableColumn colIdNV= new TableColumn("Id nhân viên");
        colIdNV.setCellValueFactory(new PropertyValueFactory("id"));
        colIdNV.setPrefWidth(20);
        
        TableColumn colTenNV = new TableColumn("Tên nhân viên");
        colTenNV.setCellValueFactory(new PropertyValueFactory("hoTen"));
        colTenNV.setPrefWidth(150);
        
        TableColumn colNgayBatDau =  new TableColumn("Ngày bắt đầu");
        colNgayBatDau.setCellValueFactory(new PropertyValueFactory("ngayBatDau"));
        colNgayBatDau.setPrefWidth(100);
        
        TableColumn colNgayKetThuc= new TableColumn("Ngày kết thúc");
        colNgayKetThuc.setCellValueFactory(new PropertyValueFactory("ngayKetThuc"));
        colNgayKetThuc.setPrefWidth(100);
        
        TableColumn colSDT= new TableColumn("SDT");
        colSDT.setCellValueFactory(new PropertyValueFactory("sdt"));
        colSDT.setPrefWidth(50);
        
        TableColumn colCMND= new TableColumn("CMND");
        colCMND.setCellValueFactory(new PropertyValueFactory("cmnd"));
        colCMND.setPrefWidth(50);
        
        TableColumn colMaCV= new TableColumn("Mã chức vụ");
        colMaCV.setCellValueFactory(new PropertyValueFactory("maChucVu"));
        colMaCV.setPrefWidth(50);
        
        TableColumn colMaCN= new TableColumn("Mã chi nhánh");
        colMaCN.setCellValueFactory(new PropertyValueFactory("maChiNhanh"));
        colMaCN.setPrefWidth(50);
        
        TableColumn colLuong= new TableColumn("Lương");
        colLuong.setCellValueFactory(new PropertyValueFactory("tienLuong"));
        colLuong.setPrefWidth(150);
        
        TableColumn colMaTK= new TableColumn("Mã tài khoản");
        colMaTK.setCellValueFactory(new PropertyValueFactory("maTK"));
        colMaTK.setPrefWidth(50);
        
        this.tbNhanVien.getColumns().addAll(colIdNV, colTenNV, colNgayBatDau, 
                colNgayKetThuc, colSDT, colCMND, colMaCV, colMaCN, colLuong, colMaTK);
    }
//khuyến mãi
    public void addKhuyenMai(ActionEvent event) throws SQLException{
        KhuyenMai km = new KhuyenMai();
        if (txtMaHHKhuyenMai.getText().matches("[0-9]") && txtNgayBDKM.getValue().toString()!= null
                &&txtNgayKTKM.getValue().toString()!=null &&Integer.parseInt(txtGiaKM.getText())>0)
        {
          try {
            
            km.setId(Integer.parseInt(this.txtMaHHKhuyenMai.getText()));
            km.setNgayBatDau(java.sql.Date.valueOf(txtNgayBDKM.getValue()));
            km.setNgayKetThuc(java.sql.Date.valueOf(txtNgayKTKM.getValue()));
            km.setGiaKhuyenMai(Integer.parseInt(this.txtGiaKM.getText()));
            KhuyenMaiServices KMsv = new KhuyenMaiServices();
            if(KMsv.checkIdKM(km)){
                    KMsv.ThemKhuyenMai(km);
                    this.loadTableKM(null);
                    Utils.showBox("Thêm thành công", Alert.AlertType.INFORMATION).show();
                 }
                 else{
                   Utils.showBox("Hàng hóa đã có khuyến mại", Alert.AlertType.WARNING).show();
                 }
            this.txtMaHHKhuyenMai.setText(null);
            this.txtNgayBDKM.setValue(null);
            this.txtNgayKTKM.setValue(null);
            this.txtGiaKM.setText(null);

        } catch (SQLException ex) {
            Utils.showBox("Thêm hàng hóa thất bại!", Alert.AlertType.WARNING).show();
                } 
        }else{
            Utils.showBox("Nhập sai định dạng!", Alert.AlertType.WARNING).show();
        }
    }
    public void xoaKhuyenMaiHandler(ActionEvent event) throws SQLException{
        if (txtMaHHKhuyenMai.getText().matches("[0-9]") && txtNgayBDKM.getValue().toString()!= null
                &&txtNgayKTKM.getValue().toString()!=null &&Integer.parseInt(txtGiaKM.getText())>0)
        {
         try{
            KhuyenMaiServices kmsv = new KhuyenMaiServices();
            KhuyenMai hh = (KhuyenMai) tbKhuyenMai.getSelectionModel().getSelectedItem();
            kmsv.XoaKhuyenMai(hh);
            this.loadTableKM(null);
            txtMaHHKhuyenMai.clear();
            txtNgayBDKM.setValue(null);
            txtNgayKTKM.setValue(null);
            txtGiaKM.clear();
         }catch(SQLException ex){
             Utils.showBox("Xóa khuyến mại thất bại", Alert.AlertType.INFORMATION).show();
            }
        }
        else
        {
            Utils.showBox("Chọn khuyến mãi trước", Alert.AlertType.INFORMATION).show();
        }
    }
    public void CapNhatKhuyenMai(ActionEvent event) throws SQLException{
           KhuyenMai newkm = new KhuyenMai();
           if (txtMaHHKhuyenMai.getText().matches("[0-9]") && txtNgayBDKM.getValue().toString()!= null
                &&txtNgayKTKM.getValue().toString()!=null &&Integer.parseInt(txtGiaKM.getText())>0)
           {
            try{
                KhuyenMaiServices sv = new KhuyenMaiServices();
                 KhuyenMai km = (KhuyenMai) tbKhuyenMai.getSelectionModel().getSelectedItem();

                 km.setId(Integer.parseInt(this.txtMaHHKhuyenMai.getText()));
                 km.setNgayBatDau(java.sql.Date.valueOf(txtNgayBDKM.getValue()));
                 km.setNgayKetThuc(java.sql.Date.valueOf(txtNgayKTKM.getValue()));
                 km.setGiaKhuyenMai(Integer.parseInt(this.txtGiaKM.getText()));
                 if(sv.checkIdKM(km)){
                    sv.CapNhatKhuyenMai(km);
                    this.loadTableKM(null);
                 }
                 else{
                   Utils.showBox("Hàng hoá này không tồn tại", Alert.AlertType.WARNING).show();
                 }
                 txtMaHHKhuyenMai.clear();
                 txtNgayBDKM.setValue(null);
                 txtNgayKTKM.setValue(null);
                 txtGiaKM.clear();
           }catch(SQLException ex){
                Utils.showBox("Cập nhật khuyến mại thất bại!", Alert.AlertType.WARNING).show();
                }
           }
           else
           {
                Utils.showBox("Nhập sai định dạng!", Alert.AlertType.WARNING).show();
           }
    }
    private void loadTableViewKhuyenMai(){
        TableColumn colKMid = new TableColumn("Id hàng hóa km");
        colKMid.setCellValueFactory(new PropertyValueFactory("id"));
        colKMid.setPrefWidth(100);

        TableColumn colNgayBD = new TableColumn("Ngay bat dau");
        colNgayBD.setCellValueFactory(new PropertyValueFactory("ngayBatDau"));
        colNgayBD.setPrefWidth(100);


        TableColumn colNgayKT =  new TableColumn("Ngay ket thuc");
        colNgayKT.setCellValueFactory(new PropertyValueFactory("ngayKetThuc"));
        colNgayKT.setPrefWidth(150);

        TableColumn colGia =  new TableColumn("Gia km");
        colGia.setCellValueFactory(new PropertyValueFactory("giaKhuyenMai"));
        colGia.setPrefWidth(150);

        this.tbKhuyenMai.getColumns().addAll(colKMid, colNgayBD, colNgayKT, colGia);
    }
    private void MouseClickTBVKhuyenMai(){
              tbKhuyenMai.setRowFactory((tbv) -> {
                  TableRow<KhuyenMai> rowKhuyenMai = new TableRow<>();
                  rowKhuyenMai.setOnMouseClicked((event) -> {
                    if(event.getClickCount() != 0 && (!rowKhuyenMai.isEmpty())){
                      KhuyenMai rowData = rowKhuyenMai.getItem();
                      this.txtMaHHKhuyenMai.clear();
                      this.txtMaHHKhuyenMai.appendText(String.valueOf(rowData.getId()));
                      this.txtNgayBDKM.setValue(null);
                      this.txtNgayBDKM.setValue((LocalDate) rowData.getNgayBatDau().toLocalDate());
                      this.txtNgayKTKM.setValue(null);
                      this.txtNgayKTKM.setValue((LocalDate) rowData.getNgayKetThuc().toLocalDate());
                      this.txtGiaKM.clear();
                      this.txtGiaKM.appendText(String.valueOf(rowData.getGiaKhuyenMai()));

            };
        });
                  return rowKhuyenMai;
              });
        }
 //Hóa đơn
        public void TaoHoaDon (ActionEvent event)throws SQLException, IOException{
        txtMaHH_HD.setDisable(false);
        txtMaCN_HD.setDisable(false);
        txtSoLuongHH_HD.setDisable(false);
        txtMaKH_HD.setDisable(false);
        txtTongTien_HD.setDisable(true);
        txtTienNhan_HD.setDisable(false);
        txtMaKH_HD.setDisable(false);
        btnThemHH_HD.setDisable(false);
        btnCapNhatHH_HD.setDisable(false);
        btnXoaHH_HD.setDisable(false);
        btnLuuHD.setDisable(false);
        HoaDonServices hds = new HoaDonServices();
        try{
            hds.TaoHoaDonTrong();
        }catch (SQLException ex)
        {
            Utils.showBox("Tạo hóa đơn thất bại", Alert.AlertType.WARNING).show();
        }   
        this.loadTableCTHD(Integer.toString(hds.getMaxHoaDon()));
        txtMaHD.setText(Integer.toString(hds.getMaxHoaDon()));
        btnTaoHD.setDisable(true);
        
    }
        public void TaoChiTietHoaDon(ActionEvent event) throws SQLException{
            HoaDonServices hds = new HoaDonServices();
            ChiTietHoaDonServices cthdsv = new ChiTietHoaDonServices();
            try {
                txtMaHD.setText(Integer.toString(hds.getMaxHoaDon()));
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setSoLuong(Float.parseFloat(this.txtSoLuongHH_HD.getText()));
//                cthd.setDonGia(Integer.parseInt(txtDonGiaHH_HD.getText()));
                cthd.setMaHangHoa(Integer.parseInt(txtMaHH_HD.getText()));
                cthd.setMaHoaDon(Integer.parseInt(txtMaHD.getText()));
                cthdsv.ThemChiTietHoaDon(cthd);
            } catch (SQLException e) {
                Utils.showBox("Tạo chi tiết hóa đơn thất bại", Alert.AlertType.INFORMATION).show();
            }
            this.loadTableCTHD(Integer.toString(hds.getMaxHoaDon()));
            totalvalue = (hds.GetTongTien(hds.getHoaDon(hds.getMaxHoaDon())));
            this.txtTongTien_HD.setText(Float.toString(hds.GetTongTien(hds.getHoaDon(hds.getMaxHoaDon()))));
            this.txtSoLuongHH_HD.setText(null);
            this.txtMaHH_HD.setText(null);
        }
        private void loadTableViewChiTietHoaDon(){
        TableColumn colMaHH_HD = new TableColumn("Mã hàng hóa");
        colMaHH_HD.setCellValueFactory(new PropertyValueFactory("maHangHoa"));
        colMaHH_HD.setPrefWidth(100);

        TableColumn colMaHD_HD = new TableColumn("Mã hóa đơn");
        colMaHD_HD.setCellValueFactory(new PropertyValueFactory("maHoaDon"));
        colMaHD_HD.setPrefWidth(100);


        TableColumn colSL_HD =  new TableColumn("Số lượng");
        colSL_HD.setCellValueFactory(new PropertyValueFactory("soLuong"));
        colSL_HD.setPrefWidth(120);

        TableColumn colGia_HD =  new TableColumn("Giá bán");
        colGia_HD.setCellValueFactory(new PropertyValueFactory("donGia"));
        colGia_HD.setPrefWidth(150);

        this.tbChiTietHoaDon.getColumns().addAll(colMaHH_HD, colMaHD_HD, colSL_HD, colGia_HD);
    }
            private void MouseClickTBVCTHD(){
              tbChiTietHoaDon.setRowFactory((tbv) -> {
                  TableRow<ChiTietHoaDon> rowCTHD = new TableRow<>();
                  rowCTHD.setOnMouseClicked((event) -> {
                    if(event.getClickCount() != 0 && (!rowCTHD.isEmpty())){
                      ChiTietHoaDon rowData = rowCTHD.getItem();
                      this.txtSoLuongHH_HD.clear();
                      this.txtSoLuongHH_HD.appendText(String.valueOf(rowData.getSoLuong()));
                      this.txtMaHH_HD.clear();
                      this.txtMaHH_HD.appendText(String.valueOf(rowData.getMaHangHoa()));
            };
        });
                  return rowCTHD;
              });
        }
    public void xoaCTHDHandler(ActionEvent event) throws SQLException{
        HoaDonServices hds = new HoaDonServices();
        if (txtMaHH_HD.getText().length() >0 && txtSoLuongHH_HD.getText().length()>0 && txtDonGia.getText().length() >0
                && txtMaHD.getText().length()>0)
        {
         try{
            ChiTietHoaDonServices cthdsv = new ChiTietHoaDonServices();
            ChiTietHoaDon cthd = (ChiTietHoaDon) tbChiTietHoaDon.getSelectionModel().getSelectedItem();
            cthdsv.XoaChiTietHoaDon(cthd);
            this.loadTableCTHD(Integer.toString(hds.getMaxHoaDon()));
            txtSoLuongHH_HD.clear();
            txtMaHH_HD.clear();
         }catch(SQLException ex){
              Utils.showBox("Xóa chi tiết hóa đơn thất bại", Alert.AlertType.ERROR).show();
            }
        }
         else
         {
                 Utils.showBox("Chọn trước khi xóa", Alert.AlertType.ERROR).show();
         }
    }
    public void CapNhatCTHD(ActionEvent event) throws SQLException, IOException{
            HoaDonServices hds = new HoaDonServices();
           ChiTietHoaDon newcthd = new ChiTietHoaDon();
            try{
                ChiTietHoaDonServices cthdsv = new ChiTietHoaDonServices();
//                 ChiTietHoaDon cthd = (ChiTietHoaDon) tbChiTietHoaDon.getSelectionModel().getSelectedItem();
                try {
                    newcthd.setSoLuong(Float.parseFloat(txtSoLuongHH_HD.getText()));
                    newcthd.setMaHangHoa(Integer.parseInt(txtMaHH_HD.getText()));
                    newcthd.setMaHoaDon(Integer.parseInt(txtMaHD.getText()));
                } catch (InputMismatchException ex) {
                    Utils.showBox("Lỗi nhập liệu!", Alert.AlertType.WARNING).show();
                }  
                 cthdsv.CapNhatChiTietHoaDon(newcthd);
                 loadTableCTHD(Integer.toString(hds.getMaxHoaDon()));
                 this.txtTongTien_HD.setText(Float.toString(hds.GetTongTien(hds.getHoaDon(hds.getMaxHoaDon()))));
                 txtSoLuongHH_HD.clear();
                txtMaHH_HD.clear();
            }
            catch(SQLException ex){
                Utils.showBox("Cập nhật chi tiết hóa đơn thất bại!", Alert.AlertType.WARNING).show();
       }
            catch (Exception ex3){
                Utils.showBox("Vui lòng chọn sản phẩm trước!", Alert.AlertType.ERROR).show();
            }
    }
      public void LuuHoaDon(ActionEvent event)throws SQLException, IOException{
          HoaDonServices hsv = new HoaDonServices();
          KhachHangServices khsv = new KhachHangServices();
          HoaDon newhd = new HoaDon();
          newhd.setId(hsv.getMaxHoaDon());
          newhd.setNgayXuatDon(java.sql.Date.valueOf(LocalDate.now()));
            int daykh = khsv.getDayOfBirth(Integer.parseInt(txtMaKH_HD.getText()));
            int monthkh = khsv.getMonthOfBirth(Integer.parseInt(txtMaKH_HD.getText()));
            float total = hsv.GetTongTien(hsv.getHoaDon(hsv.getMaxHoaDon()));
          newhd.setMaNV(userid);
          if (Float.parseFloat(txtTienNhan_HD.getText()) > totalvalue)
              {
                if(txtMaKH_HD.getText().length()>0 && txtMaCN_HD.getText().length()>0 &&txtTienNhan_HD.getText().length()>0)
                {
                    newhd.setMaKH(Integer.parseInt(txtMaKH_HD.getText()));                  
                    newhd.setMaCN(Integer.parseInt(txtMaCN_HD.getText()));
                    newhd.setTienNhan(Integer.parseInt(txtTienNhan_HD.getText()));
                    if(day == daykh && month == monthkh && hsv.GetTongTien(hsv.getHoaDon(hsv.getMaxHoaDon())) > 1000000)
                    {
                        newhd.setGiaTriCuoi(total-(float)(total*0.1));
                    }
                    else{
                        newhd.setGiaTriCuoi(total);
                    }
                    try{
                    hsv.CapNhatHoaDon(newhd);
                    }catch (Exception ex){
                      Utils.showBox("Lỗi", Alert.AlertType.ERROR).show();
                    }
                    txtMaHD.setDisable(true);
                    txtMaHH_HD.setDisable(true);
                    txtMaCN_HD.setDisable(true);
                    txtSoLuongHH_HD.setDisable(true);
                    txtTongTien_HD.setDisable(true);
                    txtTienNhan_HD.setDisable(true);
                    txtMaKH_HD.setDisable(true);
                    txtMaHD.clear();
                    txtMaHH_HD.clear();
                    txtMaCN_HD.clear();
                    txtSoLuongHH_HD.clear();
                    txtTongTien_HD.clear();
                    txtTienNhan_HD.clear();
                    txtMaKH_HD.clear();
                    btnThemHH_HD.setDisable(true);
                    btnCapNhatHH_HD.setDisable(true);
                    btnXoaHH_HD.setDisable(true);
                    btnLuuHD.setDisable(true); 
                    btnTaoHD.setDisable(false);
                    
                }
                else
                {
                    Utils.showBox("Vui lòng nhập đủ thông tin hóa đơn!", Alert.AlertType.ERROR).show(); 
                }
              }
          else{
              Utils.showBox("Số tiền nhận ít hơn tổng tiền!", Alert.AlertType.ERROR).show();
          }
          tbChiTietHoaDon.getItems().clear();
    }
      public void addKhachHang(ActionEvent event) throws SQLException, IOException{
        KhachHang kh = new KhachHang();
//        ZoneId defaultZoneId = ZoneId.systemDefault();
        if (txtMaKH.getText().matches("[0-9]")&& (txtMaKH.getText().length()>0)&&
                txtNgaySinhKH.getValue().toString()!=null &&
                 (txtCMNDKH.getText().length()>0))
                
        {
            kh.setId(Integer.parseInt(txtMaKH.getText()));
            kh.setTenKH(txtTenKH.getText());
            kh.setNgaySinh(java.sql.Date.valueOf(txtNgaySinhKH.getValue()));
            kh.setSDT(txtSDTKH.getText());
//            Instant instant = dateThamGia.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
//            kh.setNgayThamGia((java.sql.Date) Date.from(instant));
            kh.setCmnd(txtCMNDKH.getText());
            try {
                KhachHangServices khs = new KhachHangServices();
                khs.ThemKhachHang(kh);
                
                this.loadTableKH(null);
                this.txtMaKH.setText(null);
                this.txtTenKH.setText(null);
                this.txtNgaySinhKH.setValue(null);
                this.txtSDTKH.setText(null);
                this.txtCMNDKH.setText(null);
                loadTableKH(null);
            } catch (SQLException ex) {
                Utils.showBox("Add khach hang thất bại!", Alert.AlertType.WARNING).show();
            } 
        }
        else{
            Utils.showBox("Nhập sai định dạng!", Alert.AlertType.WARNING).show();
        }
    }
        
     
     private void loadTableCN(String kw) throws SQLException{
        ChiNhanhServices cn = new ChiNhanhServices();
        this.tbChiNhanh.setItems(FXCollections.observableList(cn.TimChiNhanh(kw)));
    }
     private void loadTableNV(String kw) throws SQLException{
        NhanVienServices nv = new NhanVienServices();
        this.tbNhanVien.setItems(FXCollections.observableList(nv.TimNhanVien(kw)));
    }
     private void loadTableHH(String kw) throws SQLException{
        HangHoaServices hh = new HangHoaServices();
        this.tbHangHoa.setItems(FXCollections.observableList(hh.TimHangHoa(kw)));
    }
    private void loadTableKM(String kw) throws SQLException{
        KhuyenMaiServices hh = new KhuyenMaiServices();
        this.tbKhuyenMai.setItems(FXCollections.observableList(hh.TimKhuyenMai(kw)));
    }
    private void loadTableCTHD(String kw) throws SQLException{
        ChiTietHoaDonServices cthds = new ChiTietHoaDonServices();
        this.tbChiTietHoaDon.setItems(FXCollections.observableList(cthds.TimCTHD(kw)));
    }
    private void loadTableKH(String kw) throws SQLException{
        KhachHangServices kh = new KhachHangServices();
        this.tbKhachHang.setItems(FXCollections.observableList(kh.getListKhachHang(kw)));
    }
     private void loadTableQLHH() throws SQLException{
        QuanLyHangServices qlhh = new QuanLyHangServices();
        this.tbQLHH.setItems(FXCollections.observableList(qlhh.getListQLHangHoa()));
    }
    
    public void loadCombobox() throws SQLException {
        ChiNhanhServices chiNhanhSV = new ChiNhanhServices();
        HangHoaServices hangHoaSV = new HangHoaServices();
        List<ChiNhanh> listChiNhanh = chiNhanhSV.getChiNhanh();
        List<HangHoa> listHangHoa = hangHoaSV.getListHangHoa();
        
        cbCN.setItems(FXCollections.observableList(listChiNhanh));
        cbHH.setItems(FXCollections.observableList(listHangHoa));
    }
    
    public void themHHTrongCN() throws SQLException {
        QuanLyHangServices qlHHSV = new QuanLyHangServices();
        QuanLyHang qlH = new QuanLyHang(cbCN.getValue().getId(), cbHH.getValue().getId(), Float.parseFloat(txtQuantity.getText()));
        qlHHSV.ThemHangHoaTrongChiNhanh(qlH);
        loadTableQLHH();
    }
}
