package com.covid19management;

import java.util.ArrayList;
import java.util.Scanner;

public class CitizenManager {
    static ArrayList<Citizen> listCitizen = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public CitizenManager() {

    }

    public void createCitizen() {
        System.out.print("So cong dan can them vao: ");
        int numberAdd = Integer.parseInt(input.nextLine());

        for (int i=1; i<=numberAdd; i++) {
            System.out.println("\nCong dan "+i+":");
            System.out.print("Nhap ten: ");
            String name = input.nextLine();

            System.out.print("Nhap so CMND: ");
            int identityCard;
            while(true) {
                try {
                    boolean check = true;
                    identityCard = Integer.parseInt(input.nextLine());
                    for (Citizen citizen : listCitizen) {
                        if (citizen.getIdentityCard() == identityCard) {
                            System.out.print("So CMND da ton tai! Hay nhap lai: ");
                            check = false;
                            break;
                        }
                    }
                    if (check) break;
                } catch (NumberFormatException e) {
                    System.out.print("Nhap sai dinh dang! Hay nhap lai: ");
                }
            }

            System.out.print("Nhap tuoi: ");
            int age;
            while (true) {
                try {
                    age = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Nhap sai dinh dang! Hay nhap lai: ");
                }
            }

            System.out.print("Nhap gioi tinh: ");
            String gender = input.nextLine();

            System.out.print("Nhap dia chi thuong tru: ");
            String permanentAddress = input.nextLine();

            System.out.print("Nhap dia chia tam tru: ");
            String temporaryAddress = input.nextLine();

            Citizen citizen = new Citizen(name, identityCard, age, gender, permanentAddress, temporaryAddress);
            listCitizen.add(citizen);
        }
    }

    public void display() {
        for (int i=1; i<=listCitizen.size(); i++) {
            System.out.println("CÔNG DÂN "+i+"| "+listCitizen.get(i-1));
        }
    }

    public void findByName() {
        System.out.print("Nhap ten cong dan can tim: ");
        String name = input.nextLine();
        boolean isFind = true;

        for (Citizen citizen: listCitizen) {
            if (citizen.getName().equalsIgnoreCase(name)) {
                System.out.println(citizen);
                isFind = false;
            }
        }
        if (isFind) {
            System.out.println("Khong tim thay cong dan nao!");
        }
    }

    public void findByIdentityCard() {
        System.out.print("Nhap so CMND cong dan can tim: ");
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
            System.out.println("Khong tim thay cong dan nao!");
        }
    }

    public void editHealth() {
        System.out.print("Nhap CMND cua cong dan can thiet lap: ");
        int indentityCard = Integer.parseInt(input.nextLine());

        for (Citizen citizen: listCitizen) {
            if (citizen.getIdentityCard() == indentityCard) {
                while (true) {
                        System.out.println("Chon trang thai suc khoe can thiet lap:");
                        System.out.println("1. Normal");
                        System.out.println("2. Contact");
                        System.out.println("3. Positive");
                        String choose = input.nextLine();

                        switch (choose) {
                            case "1":
                                citizen.setHealth("Normal");
                                listCitizen.set(listCitizen.indexOf(citizen), citizen);
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
                                System.out.println("Lua chon ngoai pham vi!!!");
                        }
                }
            }
        }
        System.out.println("Khong tim thay cong dan nao!");
    }

    public void setMove() {
        System.out.print("Nhap so CMND cua benh nhan: ");
        int indentityCard = Integer.parseInt(input.nextLine());

        for (Citizen citizen: listCitizen) {
            if (citizen.getIdentityCard() == indentityCard) {
                while (true) {
                    if (citizen.getHealth().equalsIgnoreCase("Contact") || citizen.getHealth().equalsIgnoreCase("Positive")) {
                        while (true) {
                            System.out.print("Nhap dia chi (nhap 0 de thoat): ");
                            String address = input.nextLine();

                            if (address.equals("0")) {
                                System.out.println(citizen);
                                return;
                            } else if (citizen.listMove.contains(address)) {
                                System.out.println("Dia chi da ton tai!");
                            } else {
                                citizen.listMove.add(address);
                                listCitizen.set(listCitizen.indexOf(citizen), citizen);
                            }
                        }
                    } else {
                        System.out.println("Benh nhan dang o trang thai suc khoe binh thuong!");
                        while (true) {
                            System.out.println("Thiet lap lai trang thai suc khoe:");
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
                                    System.out.println("Lua chon ngoai pham vi!!!");
                            }
                            if (check) break;
                        }
                    }
                }
            }
        }
        System.out.println("Khong tim thay cong dan nao!");
    }

    public void findCitizenByListMove() {
        System.out.print("Nhap so CMND cua benh nhan: ");
        int indentityCard = Integer.parseInt(input.nextLine());
        boolean isFind = true;

        for (Citizen citizen: listCitizen) {
            if (citizen.getIdentityCard() == indentityCard) {
                if (citizen.getHealth().equalsIgnoreCase("Contact") || citizen.getHealth().equalsIgnoreCase("Positive")) {
                    boolean check = true;
                    for (String address: citizen.listMove) {
                        for (Citizen citizenElement: listCitizen) {
                            if (address.equalsIgnoreCase(citizenElement.getTemporaryAddress()) && !citizenElement.getHealth().equalsIgnoreCase("Positive")) {
                                citizenElement.setHealth("Contact");
                                listCitizen.set(listCitizen.indexOf(citizenElement), citizenElement);

                                check = false;
                                System.out.println(citizenElement);
                            }
                        }
                    }
                    if (check) {
                        System.out.println("Khong co nguoi nao nam trong vung di chuyen cua benh nhan!");
                    }
                } else {
                    System.out.println("Cong dan nay co suc khoe binh thuong!");
                }

                isFind = false;
                break;
            }
        }
        if (isFind) {
            System.out.println("Khong tim thay cong dan nao!");
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
            System.out.println("Khong co benh nhan nao duong tinh COVID-19!");
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
            System.out.println("Khong co benh nhan nao dang theo doi!");
        }
    }
}
