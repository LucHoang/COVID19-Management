package com.covid19management;

import java.util.*;

public class CitizenManager {
    static ArrayList<Citizen> listCitizen = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public CitizenManager() {

    }

    public void inputCitizen(Citizen citizen, int idSkip) {
        System.out.print("Nhập tên: ");
        String name = input.nextLine();
        citizen.setName(name);

        System.out.print("Nhập số CMND: ");
        int identityCard;
        while(true) {
            try {
                boolean check = true;
                identityCard = Integer.parseInt(input.nextLine());
                for (Citizen citizen1 : listCitizen) {
                    if (citizen1.getIdentityCard() == identityCard && citizen1.getIdentityCard() != idSkip) {
                        System.out.print("Số CMND đã tồn tại! Hãy nhập lại: ");
                        check = false;
                        break;
                    }
                }
                if (check) {
                    citizen.setIdentityCard(identityCard);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Nhập sai định dạng! Hãy nhập lại: ");
            }
        }

        System.out.print("Nhập tuổi: ");
        int age;
        while (true) {
            try {
                age = Integer.parseInt(input.nextLine());
                citizen.setAge(age);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Nhập sai định dạng! Hãy nhập lại: ");
            }
        }

        System.out.print("Nhập giới tính: ");
        String gender = input.nextLine();
        citizen.setGender(gender);

        System.out.print("Nhập địa chỉ thường trú: ");
        String permanentAddress = input.nextLine();
        citizen.setPermanentAddress(permanentAddress);

        System.out.print("Nhập địa chỉ tạm trú: ");
        String temporaryAddress = input.nextLine();
        citizen.setTemporaryAddress(temporaryAddress);
    }

    public void createCitizen() {
        System.out.print("Số công dân cần thêm vào: ");
        int numberAdd = Integer.parseInt(input.nextLine());

        for (int i=1; i<=numberAdd; i++) {
            System.out.println("\nCÔNG DÂN "+i+":");
            Citizen citizen = new Citizen();
            inputCitizen(citizen,0);
            System.out.println(citizen);
            System.out.println("Đã thêm thành công!");
            listCitizen.add(citizen);
        }
    }

    public void editProfile() {
        if (listCitizen.isEmpty()) {
            System.out.println("Danh sách trống!!!");
            return;
        }
        System.out.print("Nhập số CMND của công dân cần sửa: ");
        int cmnd = Integer.parseInt(input.nextLine());
        boolean isFind = false;

        for (Citizen citizen: listCitizen) {
            if (citizen.getIdentityCard() == cmnd) {
                inputCitizen(citizen, cmnd);
                System.out.println("Đã sửa thông tin thành công!");
                System.out.println(citizen);
                isFind = true;
                break;
            }
        }
        if (!isFind) {
            System.out.println("Không tìm được công dân có số CMND: "+cmnd);
        }
    }

    public void deleteCitizen() {
        if (listCitizen.isEmpty()) {
            System.out.println("Danh sách trống!!!");
            return;
        }
        System.out.print("Nhập số CMND của công dân cần xóa: ");
        int cmnd = Integer.parseInt(input.nextLine());
        boolean isFind = false;

        for (Citizen citizen: listCitizen) {
            if (citizen.getIdentityCard() == cmnd) {
                listCitizen.remove(citizen);
                System.out.println("Đã xóa thành công!");
                isFind = true;
                break;
            }
        }
        if (!isFind) {
            System.out.println("Không tìm được công dân có số CMND: "+cmnd);
        }
    }

    public void displayList() {
        System.out.println("1. Hiển thị theo mặc định");
        System.out.println("2. Hiển thị theo tên (A-Z)");
        System.out.println("3. Hiển thị theo tên (Z-A)");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
        String select = input.nextLine();
        switch (select) {
            case "1":
                display();
                break;
            case "2":
                Collections.sort(listCitizen, new Comparator<Citizen>() {
                    @Override
                    public int compare(Citizen o1, Citizen o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                display();
                break;
            case "3":
                Collections.sort(listCitizen, new Comparator<Citizen>() {
                    @Override
                    public int compare(Citizen o1, Citizen o2) {
                        return o2.getName().compareTo(o1.getName());
                    }
                });
                display();
                break;
            case "0":
                break;
            default:
                System.out.println("Lựa chọn ngoài phạm vi!!!");
        }


    }

    public void display() {
        boolean isLoop = true;
        int start = 0;
        int end = 4;
        Scanner scanner = new Scanner(System.in);

        int count = 0;

        while (isLoop) {
            for (int i=start; i<=end; i++) {
                if (i>listCitizen.size()-1) {
                    break;
                }
                System.out.println("CÔNG DÂN "+(i+1)+"| "+listCitizen.get(i));
                count++;
            }
            System.out.print("Đã hiển thị "+count+"/"+listCitizen.size());

            if (end>=listCitizen.size()-1) break;
            System.out.println(" | Enter để xem tiếp");
            start+=5;
            end+=5;

            String check = scanner.nextLine();
            if (!check.isEmpty()) {
                isLoop = false;
            }
        }
    }

    public void findByName() {
        System.out.print("Nhập tên công dân cần tìm: ");
        String name = input.nextLine();
        boolean isFind = true;

        for (Citizen citizen: listCitizen) {
            if (citizen.getName().equalsIgnoreCase(name)) {
                System.out.println(citizen);
                isFind = false;
            }
        }
        if (isFind) {
            System.out.println("Không tìm thấy công dân nào!");
        }
    }

    public void findByIdentityCard() {
        System.out.print("Nhập số CMND công dân cần tìm: ");
        int indentityCard = Integer.parseInt(input.nextLine());
        boolean isFind = true;

        for (Citizen citizen: listCitizen) {
            if (citizen.getIdentityCard() == indentityCard) {
                System.out.println(citizen);
                isFind = false;
                break;
            }
        }
        if (isFind) {
            System.out.println("Không tìm thấy công dân nào!");
        }
    }

    public void editHealth() {
        System.out.print("Nhập CMND của công dân cần thiết lập: ");
        int indentityCard = Integer.parseInt(input.nextLine());

        for (Citizen citizen: listCitizen) {
            if (citizen.getIdentityCard() == indentityCard) {
                while (true) {
                        System.out.println("Chọn trạng thái sức khỏe cần thiết lập:");
                        System.out.println("1. Normal (trạng thái Normal sẽ xóa lộ trình di chuyển)");
                        System.out.println("2. Contact");
                        System.out.println("3. Positive");
                        String choose = input.nextLine();

                        switch (choose) {
                            case "1":
                                citizen.setHealth("Normal");
                                listCitizen.set(listCitizen.indexOf(citizen), citizen);
                                citizen.listMove.clear();
                                System.out.println(citizen);
                                return;
                            case "2":
                                citizen.setHealth("Contact");
                                listCitizen.set(listCitizen.indexOf(citizen), citizen);
                                System.out.println(citizen);
                                return;
                            case "3":
                                citizen.setHealth("Positive");
                                listCitizen.set(listCitizen.indexOf(citizen), citizen);
                                System.out.println(citizen);
                                return;
                            default:
                                System.out.println("Lựa chọn ngoài phạm vi!!!");
                        }
                }
            }
        }
        System.out.println("Không tìm thấy công dân nào!");
    }

    public void setMove() {
        System.out.print("Nhập số CMND của bệnh nhân: ");
        int indentityCard = Integer.parseInt(input.nextLine());

        for (Citizen citizen: listCitizen) {
            if (citizen.getIdentityCard() == indentityCard) {
                while (true) {
                    if (citizen.getHealth().equalsIgnoreCase("Contact") || citizen.getHealth().equalsIgnoreCase("Positive")) {
                        while (true) {
                            System.out.print("Nhập địa chỉ (nhập 0 để thoát): ");
                            String address = input.nextLine();

                            if (address.equals("0")) {
                                System.out.println(citizen);
                                return;
                            } else if (citizen.listMove.contains(address)) {
                                System.out.println("Địa chỉ đã tồn tại!");
                            } else {
                                citizen.listMove.add(address);
                                listCitizen.set(listCitizen.indexOf(citizen), citizen);
                            }
                        }
                    } else {
                        System.out.println("Bệnh nhân đang ở trạng thái sức khỏe bình thường!");
                        while (true) {
                            System.out.println("Thiết lập lại trạng thái sức khỏe:");
                            System.out.println("1. Contact");
                            System.out.println("2. Positive");
                            System.out.println("0. Exit");
                            System.out.print("Choose: ");
                            String choose = input.nextLine();
                            boolean check =false;

                            switch (choose) {
                                case "0":
                                    return;
                                case "1":
                                    citizen.setHealth("Contact");
                                    listCitizen.set(listCitizen.indexOf(citizen), citizen);
                                    check = true;
                                    break;
                                case "2":
                                    citizen.setHealth("Positive");
                                    listCitizen.set(listCitizen.indexOf(citizen), citizen);
                                    check = true;
                                    break;
                                default:
                                    System.out.println("Lựa chọn ngoài phạm vi!!!");
                            }
                            if (check) break;
                        }
                    }
                }
            }
        }
        System.out.println("Không tìm thấy công dân nào!");
    }

    public void findCitizenByListMove() {
        System.out.print("Nhập số CMND của bệnh nhân: ");
        int indentityCard = Integer.parseInt(input.nextLine());
        boolean isFind = true;

        for (Citizen citizen: listCitizen) {
            if (citizen.getIdentityCard() == indentityCard) {
                if (citizen.getHealth().equalsIgnoreCase("Contact") || citizen.getHealth().equalsIgnoreCase("Positive")) {
                    boolean check = true;
                    int count = 0;
                    for (String address: citizen.listMove) {
                        for (Citizen citizenElement: listCitizen) {
                            if (address.equalsIgnoreCase(citizenElement.getTemporaryAddress()) && !citizenElement.getHealth().equalsIgnoreCase("Positive")
                                    && !citizenElement.getHealth().equalsIgnoreCase("Contact")) {
                                citizenElement.setHealth("Contact");
                                listCitizen.set(listCitizen.indexOf(citizenElement), citizenElement);

                                check = false;
                                System.out.println(citizenElement);
                                count++;
                            }
                        }
                    }
                    if (check) {
                        System.out.println("Không có người nào nằm trong vùng di chuyển của bệnh nhân!");
                    } else {
                        System.out.println("Đã chuyển "+count+" công dân vào danh sách theo dõi!");
                    }
                } else {
                    System.out.println("Công dân này có sức khỏe bình thường!");
                }

                isFind = false;
                break;
            }
        }
        if (isFind) {
            System.out.println("Không tìm thấy công dân nào!");
        }
    }

    public void displayPositive() {
        boolean check = true;
        for (Citizen citizen: listCitizen) {
            if (citizen.getHealth().equalsIgnoreCase("Positive")) {
                System.out.println(citizen);
                check = false;
            }
        }
        if (check) {
            System.out.println("Không có bệnh nhân nào dương tính COVID-19!");
        }
    }

    public void displayContact() {
        boolean check = true;
        for (Citizen citizen: listCitizen) {
            if (citizen.getHealth().equalsIgnoreCase("Contact")) {
                System.out.println(citizen);
                check = false;
            }
        }
        if (check) {
            System.out.println("Không có bệnh nhân nào đang theo dõi!");
        }
    }

    public void checkAddressPositive() {
        Map<String, Integer> map = new TreeMap<>();
        ArrayList<String> temp = new ArrayList<>();

        for (Citizen citizen: listCitizen) {
            if (citizen.getHealth().equals("Positive")) {
                temp.add(citizen.getTemporaryAddress().toUpperCase(Locale.ROOT));
            }
        }

        if (temp.isEmpty()) {
            System.out.println("Chưa có bệnh nhân dương tính!!!");
            return;
        }

        for(int i=0; i<temp.size(); i++) {
            if (map.containsKey(temp.get(i))) {
                int value = map.get(temp.get(i))+1;
                map.put(temp.get(i), value);
            } else {
                map.put(temp.get(i), 1);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key)+" ca dương tính!");
        }

    }
}
