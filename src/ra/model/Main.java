package ra.model;

import java.util.Scanner;

public class Main {
    private static Product[] products = new Product[100];

    static {
        products[0] = new Product("P001", "Sản phẩm 1", 100, 150, 50, 10, "Mô tả sản phẩm 1", true);
        products[1] = new Product("P002", "Sản phẩm 2", 120, 180, 60, 15, "Mô tả sản phẩm 2", true);
        products[2] = new Product("P003", "Sản phẩm 3", 150, 200, 50, 20, "Mô tả sản phẩm 3", false);
    }

    private static int length = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(
                    "1. Nhập thông tin cho n sản phẩm (n nhập từ bàn phím) \n" +

                            "2. Hiển thị thông tin các sản phẩm \n" +

                            "3. Tính lợi nhuận các sản phẩm \n" +

                            "4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần \n" +

                            "5. Thống kê các sản phẩm theo khoảng giá bán \n" +

                            "6. Tìm các sản phẩm theo tên sản phẩm \n" +

                            "7. Nhập sản phẩm \n" +

                            "8. Bán sản phẩm  \n" +

                            "9. Cập nhật trạng thái sản phẩm theo mã sản phẩm\n" +

                            "10. Xóa theo mã sản phẩm\n" +

                            "0. Thoát ");
            System.out.println("Mời lựa chọn chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    showAllProduct();
                    break;
                case 3:
                    calculateProfit();
                    break;
                case 4:
                    sortProfit();
                    break;
                case 5:
                    exportPriceRange();
                    break;
                case 6:
                    searchProductName();
                    break;
                case 7:
                    importProduct();
                    break;
                case 8:
                    sellProduct();
                    break;
                case 9:
                    updateStatusProduct();
                    break;
                case 10:
                    deleteProduct();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Nhập liệu sai !!! Vui lòng nhập lại");
            }
        } while (true);
    }

    public static void createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Muốn nhập thêm mấy sản phẩm : ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            boolean checkID = false;
            do {
                System.out.println("Nhập mã sản phẩm (độ dài 4 ký tự, bắt đầu bằng 'P'): ");
                String inputProductId = scanner.nextLine();
                if (inputProductId.length() == 4 && inputProductId.charAt(0) == 'P') {
                    boolean checkNewID = false;
                    for (int j = 0; j < length; j++) {
                        if (products[j].getProductId().equals(inputProductId)) {
                            checkNewID = true;
                            break;
                        }
                    }
                    if (!checkNewID) {
                        checkID = true;
                        products[length] = new Product();
                        products[length].inputData(scanner);
                        products[length].setProductId(inputProductId);
                        length++;
                    } else {
                        System.out.println("Mã sản phẩm đã tồn tại. Vui lòng nhập lại.");
                    }
                } else {
                    System.out.println("Mã sản phẩm không hợp lệ. Vui lòng nhập lại.");
                }
            } while (!checkID);
        }
    }

    public static void showAllProduct() {
        for (int i = 0; i < length; i++) {
            products[i].displayData();
        }
    }

    public static void calculateProfit() {
        System.out.println("Lợi nhuận của các sản phẩm:");
        for (int i = 0; i < length; i++) {
            products[i].calProfit();
            System.out.println("Sản phẩm " + products[i].getProductId() + ":" + products[i].getProfit());
        }
    }

    public static void sortProfit() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (products[i].getProfit() > products[j].getProfit()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp sản phẩm theo profit giảm dần.");
    }

    //    Chức năng 5: thống kê sản phẩm theo giá bán trong khoảng từ fromPrice đến toPrice
    public static void exportPriceRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giá thấp nhất trong khoảng cần thống kê");
        float fromPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá cao nhất trong khoảng cần thống kê");
        float toPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Sản phẩm trong khoảng giá từ " + fromPrice + "đến " + toPrice + "là: ");
        boolean checkExportPrice = false;
        for (int i = 0; i < length; i++) {
            if (products[i].getExportPrice() >= fromPrice && products[i].getExportPrice() <= toPrice) {
                products[i].displayData();
                checkExportPrice = true;
            }
        }
        if (!checkExportPrice) {
            System.out.println("Không có sản phẩm nào trong khoảng giá bán trên");
        }
    }

    public static void searchProductName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên sản phẩm cần tìm");
        String inputSearchName = scanner.nextLine();
        boolean checkName = false;
        for (int i = 0; i < length; i++) {
            if (products[i].getProductName().equals(inputSearchName)) {
                products[i].displayData();
                checkName = true;
            }
        }
        if (!checkName) {
            System.out.println("Không có sản phẩm cần tìm");
        }
    }

    public static void importProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm:");
        String importProductId = scanner.nextLine();
        boolean checkImport = false;
        for (int i = 0; i < length; i++) {
            if (products[i].getProductId().equals(importProductId)) {
                checkImport = true;
                System.out.println("Nhập số lượng cần thêm: ");
                int addQuantity = Integer.parseInt(scanner.nextLine());
                products[i].setQuantity(products[i].getQuantity() + addQuantity);
                System.out.println("Số lượng sản phẩm đã đượpc cập nhật!");
                break;
            }
        }
        if (!checkImport) {
            System.out.println("Không tìm thấy mã sản phẩm!!! Vui lòng nhập lại");
        }
    }

    public static void sellProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm : ");
        String inputProductName = scanner.nextLine();
        boolean checkName = false;
        for (int i = 0; i < length; i++) {
            if (products[i].getProductName().equals(inputProductName)) {
                checkName = true;
                if (products[i].isStatus()) {
                    System.out.println("Nhập số lượng sản phẩm cần bán: ");
                    int sellQuantity = Integer.parseInt(scanner.nextLine());
                    if (sellQuantity <= products[i].getQuantity()) {
                        products[i].setQuantity(products[i].getQuantity() - sellQuantity);
                        System.out.println("Bán thành công");
                    } else {
                        System.out.println("Số lượng sản phẩm không đủ!!");
                    }
                } else {
                    System.out.println("Sản phẩm không tồn tại");
                }
            }
        }
        if (!checkName) {
            System.out.println("Không có tên sản phẩm");
        }
    }

    public static void updateStatusProduct(){
        boolean checkId = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập mã sản phẩm (độ dài 4 ký tự, bắt đầu bằng 'P'): ");
            String inputProductId = scanner.nextLine();
            if (inputProductId.length() == 4 && inputProductId.charAt(0) == 'P') {
                checkId = true;
                boolean checkUpdate = false;
                for (int i = 0; i < length; i++) {
                    if (products[i].getProductId().equals(inputProductId)){
                        checkUpdate =true;
                        if (products[i].isStatus()) {
                            products[i].setStatus(false);
                            System.out.println("Đã cập nhật trạng thái mã ("+inputProductId+ ") chuyển sang : Chưa bán");
                        } else {
                            products[i].setStatus(true);
                            System.out.println("Đã cập nhật trạng thái mã ("+inputProductId+ ") chuyển sang : Đang bán");
                        }
                        break;
                    }
                }
                if (!checkUpdate){
                    System.out.println("Mã sản phẩm không tồn tại ");
                }
            } else {
                System.out.println("Nhập liệu sai !!!!! Vui lòng nhập lại.");
            }
        }while (!checkId);
    }

    public static void deleteProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm cần xóa:");
        String delProductId = scanner.nextLine();
        boolean checkDelete = false;
        for (int i = 0; i < length; i++) {
            if (products[i].getProductId().equals(delProductId)) {
                checkDelete = true;
                for (int j = i; j < length - 1; j++) {
                    products[j] = products[j + 1];
                }
                length--;
                System.out.println("Đã xóa sản phẩm có mã: " + delProductId);
                break;
            }
        }
        if (!checkDelete) {
            System.out.println("Không tìm thấy sản phẩm có mã: " + delProductId);
        }
    }
}
