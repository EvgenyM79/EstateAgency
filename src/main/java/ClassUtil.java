import java.sql.SQLException;
import java.util.*;

public class ClassUtil{

    public void startProject() throws SQLException, Exception {
        try {
            System.out.println("Создание структуры БД и занесение первоначальной информаци");
            ObjectDAO obj = new ObjectDAO();
            Parents parent1 = new Parents("Иван", "Петров", 36);
            AreaStreet areaStreet = new AreaStreet("Куйбышева", "Октябрьский");
            Passport passport1 = new Passport("6403", 333234543, "Куйбышева", 57, 7, areaStreet);
            AreaStreet areaStreet2 = new AreaStreet("Первомайская", "Октябрьский");
            Children child1 = new Children("Миша", "Петров", 5);
            EducateBuilding educateBuilding1 = new EducateBuilding("Школа № 23", "Первомайская", 7, areaStreet2);
            AreaStreet areaStreet3 = new AreaStreet("Декабристов", "Октябрьский");
            Children child2 = new Children("Анна", "Петровна", 2);
            EducateBuilding educateBuilding2 = new EducateBuilding("Школа № 12", "Декабристов", 15, areaStreet3);
            parent1.setPassport(passport1);
            child1.setEducateBuilding(educateBuilding1);
            child2.setEducateBuilding(educateBuilding2);
            Parents parent2 = new Parents("Вера", "Петровна", 30);
            Passport passport2 = new Passport("6503", 333234443, "Куйбышева", 57, 7,areaStreet);
            parent2.setPassport(passport2);
            List<Parents> parentsList = new ArrayList<>();
            parentsList.add(parent1);
            parentsList.add(parent2);
            child1.setParents(parentsList);
            child2.setParents(parentsList);
            obj.save(educateBuilding1);
            obj.save(educateBuilding2);
            obj.save(passport1);
            obj.save(passport2);
            obj.save(parent1);
            obj.save(parent2);
            obj.save(child1);
            obj.save(child2);



            Parents parent3 = new Parents("Николай", "Сергеевич", 32);
            areaStreet = new AreaStreet("Гоголя", "Октябрьский");
            Passport passport3 = new Passport("6573", 333124543, "Гоголя", 44, 9,areaStreet);
            parent3.setPassport(passport3);
            Parents parent4 = new Parents("Анна", "Сергеевна", 27);
            Passport passport4 = new Passport("6023", 333124234, "Гоголя", 44, 9,areaStreet);
            Children child3 = new Children("Юлия", "Сергеевна", 4);
            parent4.setPassport(passport4);
            parentsList.clear();
            parentsList.add(parent3);
            parentsList.add(parent4);
            child3.setParents(parentsList);
            child3.setEducateBuilding(educateBuilding1);
            obj.save(passport3);
            obj.save(passport4);
            obj.save(parent3);
            obj.save(parent4);
            obj.save(child3);

            AreaStreet areaStreet5 = new AreaStreet("Тверитина", "Октябрьский");
            EducateBuilding educateBuilding5 = new EducateBuilding("Школа № 27", "Тверитина", 30, areaStreet5);
            obj.save(educateBuilding5);

            areaStreet5 = new AreaStreet("Ленина", "Центральный");
            educateBuilding5 = new EducateBuilding("Школа № 5", "Ленина", 9, areaStreet5);
            obj.save(educateBuilding5);

            System.out.println("Вывод всего списка людей");
            //Вывод всех людей
            String objParents = "Parents";
            List<Parents> list = obj.getObjFromTable(objParents);
            System.out.println(list + "\n");

             //Вывод всех параметров по одному человеку
            System.out.println("Вывод всей информации по одному человеку, включая паспорт и детей");
            Parents p = obj.findByIdParent(1);
            Passport pt = p.getPassport();
            System.out.println(p);
            System.out.println(pt);
            List <Children> c = p.getChildren();
            for (Children ch: c){
                EducateBuilding e = ch.getEducateBuilding();
                System.out.println(ch);
                System.out.println(e);
            }
            System.out.println("\n");

            //Вывод всех параметров по одному ребенку
            System.out.println("Вывод всей информации по ребенку у которого планируем изменить учебное заведение:");
            Children ch = obj.findByIdChild(3);
            EducateBuilding eb = obj.findByIdEducation(ch.getEb_id());
            System.out.println("Изменить учебное заведение у ребенка: " + ch);
            System.out.println(eb + "\n");
            System.out.println("Район в котором меняем: " + eb.getAreaStreet().getAs_area());

            //Вывод всех параметров по школам в одном районе
            List<EducateBuilding> listEducation = obj.getObjFromTable("EducateBuilding", String.valueOf(eb.getAreaStreet().getAs_area()));
            int j = 0;
            System.out.println("Список учебных заведений в этом районе");
            for (EducateBuilding ed5: listEducation){
                System.out.println("Номер записи: " + j++ + ed5);
            }
            System.out.println("Вввежди номер учебного заведения для изменения у ребенка");
            Scanner sc = new Scanner(System.in);
            int nEducationBuilding = sc.nextInt();
            ch.setEducateBuilding(listEducation.get(nEducationBuilding));
            obj.merge(ch);
            System.out.println("Теперь у ребенка:");
            System.out.println(ch);
            System.out.println("Учебное заведение:");
            System.out.println(ch.getEducateBuilding());

        } catch (Exception e) {
            System.out.println("Ошибка работы с данных:");
        }
    }
}
