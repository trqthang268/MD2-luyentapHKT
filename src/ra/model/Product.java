package ra.model;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {

    }

    public Product(String productId, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //  Phương thức inputData
    public void inputData(Scanner scanner) {
//        Nhập ID sản phẩm
//        boolean checkId = false;
//        do {
//            System.out.println("Nhập mã sản phẩm (Bắt đầu bằng 'P', độ dài 4 ký tự):");
//            String inputId = scanner.nextLine();
//            if (inputId.length() == 4 && inputId.charAt(0) == 'P') {
//                checkId = true;
//                productId = inputId;
//                System.out.println("Mã hợp lệ");
//            } else {
//                System.out.println("Mã sản phẩm không hợp lệ!!! Vui lòng nhập lại.");
//            }
//            ;
//        } while (!checkId);

//        Nhập tên sản phẩm
        boolean checkName = false;
        do {
            System.out.println("Nhập tên sản phẩm(5-50 ký tự):");
            String inputName = scanner.nextLine();
            if (inputName.length() >= 5 && inputName.length() <= 50) {
                checkName = true;
                productName = inputName;
                System.out.println("Tên hợp lệ");
            } else {
                System.out.println("Tên không hợp lệ!!! Vui lòng nhập lại");
            }
        } while (!checkName);

//        Nhập giá nhập có giá trị lớn hơn 0
        boolean checkImport = false;
        do {
            System.out.println("Nhập giá trị Giá nhập sản phẩm:");
            float inputImport = Float.parseFloat(scanner.nextLine());
            if (inputImport > 0) {
                importPrice = inputImport;
                checkImport = true;
                System.out.println("Giá nhập hợp lệ");
            } else {
                System.out.println("Giá nhập không hợp lệ");
            }
        } while (!checkImport);

//      Nhập giá xuất có giá trị lớn hơn ít nhất 20% so với giá nhập
        boolean checkExport = false;
        do {
            System.out.println("Nhập giá trị Giá xuất sản phẩm:");
            float inputExport = Float.parseFloat(scanner.nextLine());
            if (inputExport > getImportPrice() * 1.2) {
                exportPrice = inputExport;
                checkExport = true;
                System.out.println("Giá xuất hợp lệ");
            } else {
                System.out.println("Giá xuất không hợp lệ!! Vui lòng nhập lại");
            }
            ;
        } while (!checkExport);

//      Nhập số lượng sản phẩm có giá trị lớn hơn 0
        boolean checkQuantity = false;
        do {
            System.out.println("Nhập số lượng sản phẩm:");
            int inputQuantity = Integer.parseInt(scanner.nextLine());
            if (inputQuantity > 0) {
                quantity = inputQuantity;
                checkQuantity = true;
                System.out.println("Số lượng sản phẩm hợp lệ");
            } else {
                System.out.println("Số lượng sản phẩm không hợp lệ");
            }
        } while (!checkQuantity);

//        Nhập mô tả sản phẩm
        System.out.println("Nhập mô tả sản phẩm:");
        descriptions = scanner.nextLine();
//        Nhập trạng thái sản phẩm
        System.out.println("Nhập trạng thái sản phẩm:");
        status = Boolean.parseBoolean(scanner.nextLine());
    }

    //    phương thức displayData(status: true-đang bán / false-không bán
    public void displayData() {
        System.out.println("Product{" +
                "productId='" + productId + "\'" +
                ", productName='" + productName + "\'" +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", profit=" + profit +
                ", quantity=" + quantity +
                ", descriptions='" + descriptions + "\'" +
                ", status=" + (status ? "Đang bán" : "Không bán") +
                "}"
        );
        System.out.println("========================================");
    }

    //    Phương thức calProfit tính lợi nhuận sản phẩm
    public void calProfit() {
        profit = exportPrice - importPrice;
    }

    ;

}

