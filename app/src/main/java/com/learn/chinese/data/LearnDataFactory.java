package com.learn.chinese.data;

import com.learn.chinese.R;
import com.learn.chinese.bean.LearnData;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/6  10:58
 */
public class LearnDataFactory {
    public static List<LearnData> makeLearnData(int type) {
        switch (type) {
            case 0:
                return getMainLearnData();
            case 1:
                return getNumberData();
            case 2:
                return getColorData();
            case 3:
                return getFoodData();
            case 4:
                return getVegetableData();
            case 5:
                return getFruitData();
            case 6:
                return getDrinksData();
            case 7:
                return getFamilyData();
            case 8:
                return getWildAnimalData();
            case 9:
                return getFarmAnimalData();
            case 10:
                return getSeaAnimalData();
            case 11:
                return getPetData();
            case 12:
                return getInsectData();
            case 13:
                return getTransportationData();
            case 14:
                return getMusicData();
            case 15:
                return getWeekData();
            case 16:
                return getMonthData();
            case 17:
                return getSeasonData();
            case 18:
                return getWeatherData();
            case 19:
                return getSchoolData();
            case 20:
                return getHumanBodyData();
            case 21:
                return getClothingData();
            case 22:
                return getHolidayData();
            case 23:
                return getPhysicalData();
            case 24:
                return getCityData();
            case 25:
                return getBedroomData();
            case 26:
                return getBathroomData();
            case 27:
                return getKitchenData();
            case 28:
                return getLivingData();
            case 29:
                return getShapeData();
            case 30:
                return getNaturalData();
            case 31:
                return getOppositeData();
            case 32:
                return getVerbData();
            case 33:
                return getScienceData();
            case 34:
                return getElectricalData();
            case 35:
                return getOuterData();
        }
        return getMainLearnData();
    }

    private static List<LearnData> getMainLearnData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData.Builder("数字", "Number", 1, R.drawable.numero0)
                .addIcon1(R.drawable.numero0_1star).addIcon2(R.drawable.numero0_2star)
                .addIcon3(R.drawable.numero0_3star).addIcon4(R.drawable.numero0_4star).build());
        learnDataList.add(new LearnData.Builder("颜色", "Color", 2, R.drawable.color0)
                .addIcon1(R.drawable.color0_1star).addIcon2(R.drawable.color0_2star)
                .addIcon3(R.drawable.color0_3star).addIcon4(R.drawable.color0_4star).build());
        learnDataList.add(new LearnData.Builder("食物", "Food", 3, R.drawable.food0)
                .addIcon1(R.drawable.food0_1star).addIcon2(R.drawable.food0_2star)
                .addIcon3(R.drawable.food0_3star).addIcon4(R.drawable.food0_4star).build());
        learnDataList.add(new LearnData.Builder("蔬菜", "Vegetable", 4, R.drawable.vegetable0)
                .addIcon1(R.drawable.vegetable0_1star).addIcon2(R.drawable.vegetable0_2star)
                .addIcon3(R.drawable.vegetable0_3star).addIcon4(R.drawable.vegetable0_4star).build());
        learnDataList.add(new LearnData.Builder("水果", "Fruit", 5, R.drawable.fruit0)
                .addIcon1(R.drawable.fruit0_1star).addIcon2(R.drawable.fruit0_2star)
                .addIcon3(R.drawable.fruit0_3star).addIcon4(R.drawable.fruit0_4star).build());
        learnDataList.add(new LearnData.Builder("饮料和糖果", "Drinks and sweet", 6, R.drawable.drink0)
                .addIcon1(R.drawable.drink0_1star).addIcon2(R.drawable.drink0_2star)
                .addIcon3(R.drawable.drink0_3star).addIcon4(R.drawable.drink0_4star).build());
        learnDataList.add(new LearnData.Builder("家庭", "Family", 7, R.drawable.family0)
                .addIcon1(R.drawable.family0_1star).addIcon2(R.drawable.family0_2star)
                .addIcon3(R.drawable.family0_3star).addIcon4(R.drawable.family0_4star).build());
        learnDataList.add(new LearnData.Builder("野生动物", "Wild animal", 8, R.drawable.wildanimal0)
                .addIcon1(R.drawable.wildanimal0_1star).addIcon2(R.drawable.wildanimal0_2star)
                .addIcon3(R.drawable.wildanimal0_3star).addIcon4(R.drawable.wildanimal0_4star).build());
        learnDataList.add(new LearnData.Builder("农场动物", "Farm animal", 9, R.drawable.farmanimal0)
                .addIcon1(R.drawable.farmanimal0_1star).addIcon2(R.drawable.farmanimal0_2star)
                .addIcon3(R.drawable.farmanimal0_3star).addIcon4(R.drawable.farmanimal0_4star).build());
        learnDataList.add(new LearnData.Builder("海洋动物", "Sea animal", 10, R.drawable.seanimals0)
                .addIcon1(R.drawable.seanimals0_1star).addIcon2(R.drawable.seanimals0_2star)
                .addIcon3(R.drawable.seanimals0_3star).addIcon4(R.drawable.seanimals0_4star).build());
        learnDataList.add(new LearnData.Builder("宠物", "Pet", 11, R.drawable.pet0)
                .addIcon1(R.drawable.pet0_1star).addIcon2(R.drawable.pet0_2star)
                .addIcon3(R.drawable.pet0_3star).addIcon4(R.drawable.pet0_4star).build());
        learnDataList.add(new LearnData.Builder("昆虫", "insect", 12, R.drawable.insect0)
                .addIcon1(R.drawable.insect0_1star).addIcon2(R.drawable.insect0_2star)
                .addIcon3(R.drawable.insect0_3star).addIcon4(R.drawable.insect0_4star).build());
        learnDataList.add(new LearnData.Builder("交通工具", "Transportation", 13, R.drawable.tran0)
                .addIcon1(R.drawable.tran0_1star).addIcon2(R.drawable.tran0_2star)
                .addIcon3(R.drawable.tran0_3star).addIcon4(R.drawable.tran0_4star).build());
        learnDataList.add(new LearnData.Builder("音乐", "Music", 14, R.drawable.musical_instrument0)
                .addIcon1(R.drawable.musical_instrument0_1star).addIcon2(R.drawable.musical_instrument0_2star)
                .addIcon3(R.drawable.musical_instrument0_3star).addIcon4(R.drawable.musical_instrument0_4star).build());
        learnDataList.add(new LearnData.Builder("星期", "Week", 15, R.drawable.daysweek0)
                .addIcon1(R.drawable.daysweek0_1star).addIcon2(R.drawable.daysweek0_2star)
                .addIcon3(R.drawable.daysweek0_3star).addIcon4(R.drawable.daysweek0_4star).build());
        learnDataList.add(new LearnData.Builder("月份", "Month", 16, R.drawable.month0)
                .addIcon1(R.drawable.month0_1star).addIcon2(R.drawable.month0_2star)
                .addIcon3(R.drawable.month0_3star).addIcon4(R.drawable.month0_4star).build());
        learnDataList.add(new LearnData.Builder("季节", "Season", 17, R.drawable.season0)
                .addIcon1(R.drawable.season0_1star).addIcon2(R.drawable.season0_2star)
                .addIcon3(R.drawable.season0_3star).addIcon4(R.drawable.season0_4star).build());
        learnDataList.add(new LearnData.Builder("天气", "Weather", 18, R.drawable.weather0)
                .addIcon1(R.drawable.weather0_1star).addIcon2(R.drawable.weather0_2star)
                .addIcon3(R.drawable.weather0_3star).addIcon4(R.drawable.weather0_4star).build());
        learnDataList.add(new LearnData.Builder("学校", "School", 19, R.drawable.school0)
                .addIcon1(R.drawable.school0_1star).addIcon2(R.drawable.school0_2star)
                .addIcon3(R.drawable.school0_3star).addIcon4(R.drawable.school0_4star).build());
        learnDataList.add(new LearnData.Builder("人体", "Human body", 20, R.drawable.body0)
                .addIcon1(R.drawable.body0_1star).addIcon2(R.drawable.body0_2star)
                .addIcon3(R.drawable.body0_3star).addIcon4(R.drawable.body0_4star).build());
        learnDataList.add(new LearnData.Builder("衣服", "Clothing", 21, R.drawable.clothes0)
                .addIcon1(R.drawable.clothes0_1star).addIcon2(R.drawable.clothes0_2star)
                .addIcon3(R.drawable.clothes0_3star).addIcon4(R.drawable.clothes0_4star).build());
        learnDataList.add(new LearnData.Builder("假日", "Holiday", 22, R.drawable.holidays0)
                .addIcon1(R.drawable.holidays0_1star).addIcon2(R.drawable.holidays0_2star)
                .addIcon3(R.drawable.holidays0_3star).addIcon4(R.drawable.holidays0_4star).build());
        learnDataList.add(new LearnData.Builder("体育", "Physical education", 23, R.drawable.sport0)
                .addIcon1(R.drawable.sport0_1star).addIcon2(R.drawable.sport0_2star)
                .addIcon3(R.drawable.sport0_3star).addIcon4(R.drawable.sport0_4star).build());
        learnDataList.add(new LearnData.Builder("城市", "City", 24, R.drawable.city0)
                .addIcon1(R.drawable.city0_1star).addIcon2(R.drawable.city0_2star)
                .addIcon3(R.drawable.city0_3star).addIcon4(R.drawable.city0_4star).build());
        learnDataList.add(new LearnData.Builder("卧室", "Bedroom", 25, R.drawable.bedroom0)
                .addIcon1(R.drawable.bedroom0_1star).addIcon2(R.drawable.bedroom0_2star)
                .addIcon3(R.drawable.bedroom0_3star).addIcon4(R.drawable.bedroom0_4star).build());
        learnDataList.add(new LearnData.Builder("卫生间", "Bathroom", 26, R.drawable.bathroom0)
                .addIcon1(R.drawable.bathroom0_1star).addIcon2(R.drawable.bathroom0_2star)
                .addIcon3(R.drawable.bathroom0_3star).addIcon4(R.drawable.bathroom0_4star).build());
        learnDataList.add(new LearnData.Builder("厨房", "Kitchen", 27, R.drawable.kitchen0)
                .addIcon1(R.drawable.kitchen0_1star).addIcon2(R.drawable.kitchen0_2star)
                .addIcon3(R.drawable.kitchen0_3star).addIcon4(R.drawable.kitchen0_4star).build());
        learnDataList.add(new LearnData.Builder("客厅", "Living room", 28, R.drawable.livingroom0)
                .addIcon1(R.drawable.livingroom0_1star).addIcon2(R.drawable.livingroom0_2star)
                .addIcon3(R.drawable.livingroom0_3star).addIcon4(R.drawable.livingroom0_4star).build());
        learnDataList.add(new LearnData.Builder("形状", "Shape", 29, R.drawable.shape0)
                .addIcon1(R.drawable.shape0_1star).addIcon2(R.drawable.shape0_2star)
                .addIcon3(R.drawable.shape0_3star).addIcon4(R.drawable.shape0_4star).build());
        learnDataList.add(new LearnData.Builder("自然景观", "Natural landscape", 30, R.drawable.nature0)
                .addIcon1(R.drawable.nature0_1star).addIcon2(R.drawable.nature0_2star)
                .addIcon3(R.drawable.nature0_3star).addIcon4(R.drawable.nature0_4star).build());
        learnDataList.add(new LearnData.Builder("相反词", "Opposite word", 31, R.drawable.opposite0)
                .addIcon1(R.drawable.opposite0_1star).addIcon2(R.drawable.opposite0_2star)
                .addIcon3(R.drawable.opposite0_3star).addIcon4(R.drawable.opposite0_4star).build());
        learnDataList.add(new LearnData.Builder("动词", "Verb", 32, R.drawable.actionverb0)
                .addIcon1(R.drawable.actionverb0_1star).addIcon2(R.drawable.actionverb0_2star)
                .addIcon3(R.drawable.actionverb0_3star).addIcon4(R.drawable.actionverb0_4star).build());
        learnDataList.add(new LearnData.Builder("科技", "Science and technology", 33, R.drawable.tech0)
                .addIcon1(R.drawable.tech0_1star).addIcon2(R.drawable.tech0_2star)
                .addIcon3(R.drawable.tech0_3star).addIcon4(R.drawable.tech0_4star).build());
        learnDataList.add(new LearnData.Builder("电器用品", "Electrical Appliances", 34, R.drawable.appliance0)
                .addIcon1(R.drawable.appliance0_1star).addIcon2(R.drawable.appliance0_2star)
                .addIcon3(R.drawable.appliance0_3star).addIcon4(R.drawable.appliance0_4star).build());
        learnDataList.add(new LearnData.Builder("外太空", "Outer space", 35, R.drawable.space0)
                .addIcon1(R.drawable.space0_1star).addIcon2(R.drawable.space0_2star)
                .addIcon3(R.drawable.space0_3star).addIcon4(R.drawable.space0_4star).build());
        return learnDataList;
    }

    private static List<LearnData> getNumberData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("0", "Zero", 1, R.drawable.numero1));
        learnDataList.add(new LearnData("1", "One", 1, R.drawable.numero2));
        learnDataList.add(new LearnData("2", "Two", 1, R.drawable.numero3));
        learnDataList.add(new LearnData("3", "Three", 1, R.drawable.numero4));
        learnDataList.add(new LearnData("4", "Four", 1, R.drawable.numero5));
        learnDataList.add(new LearnData("5", "Five", 1, R.drawable.numero6));
        learnDataList.add(new LearnData("6", "Six", 1, R.drawable.numero7));
        learnDataList.add(new LearnData("7", "Seven", 1, R.drawable.numero8));
        learnDataList.add(new LearnData("8", "Eight", 1, R.drawable.numero9));
        learnDataList.add(new LearnData("9", "Nine", 1, R.drawable.numero10));
        learnDataList.add(new LearnData("10", "Ten", 1, R.drawable.numero11));
        learnDataList.add(new LearnData("11", "Eleven", 1, R.drawable.numero12));
        learnDataList.add(new LearnData("12", "Twelve", 1, R.drawable.numero13));
        learnDataList.add(new LearnData("13", "Thirteen", 1, R.drawable.numero14));
        learnDataList.add(new LearnData("14", "Fourteen", 1, R.drawable.numero15));
        learnDataList.add(new LearnData("15", "Fifteen", 1, R.drawable.numero16));
        learnDataList.add(new LearnData("16", "Sixteen", 1, R.drawable.numero17));
        learnDataList.add(new LearnData("17", "Seventeen", 1, R.drawable.numero18));
        learnDataList.add(new LearnData("18", "Eighteen", 1, R.drawable.numero19));
        learnDataList.add(new LearnData("19", "Nineteen", 1, R.drawable.numero20));
        learnDataList.add(new LearnData("20", "Twenty", 1, R.drawable.numero21));
        learnDataList.add(new LearnData("21", "Twenty One", 1, R.drawable.numero22));
        learnDataList.add(new LearnData("22", "Twenty Two", 1, R.drawable.numero23));
        learnDataList.add(new LearnData("23", "Twenty Three", 1, R.drawable.numero24));
        learnDataList.add(new LearnData("30", "Thirty", 1, R.drawable.numero25));
        learnDataList.add(new LearnData("40", "Forty", 1, R.drawable.numero26));
        learnDataList.add(new LearnData("50", "Fifty", 1, R.drawable.numero27));
        learnDataList.add(new LearnData("60", "Sixty", 1, R.drawable.numero28));
        learnDataList.add(new LearnData("70", "Seventy", 1, R.drawable.numero29));
        learnDataList.add(new LearnData("80", "Eighty", 1, R.drawable.numero30));
        learnDataList.add(new LearnData("90", "Ninety", 1, R.drawable.numero31));
        learnDataList.add(new LearnData("100", "One Hundred", 1, R.drawable.numero32));
        learnDataList.add(new LearnData("101", "One Hundred One", 1, R.drawable.numero33));
        learnDataList.add(new LearnData("200", "Two Hundred", 1, R.drawable.numero34));
        learnDataList.add(new LearnData("300", "Three Hundred", 1, R.drawable.numero35));
        learnDataList.add(new LearnData("1000", "One Thousand", 1, R.drawable.numero36));
        // learnDataList.add(new LearnData("100万", "One Million", 1, R.drawable.numero37));
        learnDataList.add(new LearnData("100万", "One Million", 1, R.drawable.numero37_s));
        return learnDataList;
    }

    private static List<LearnData> getColorData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("红色", "Red", 2, R.drawable.color1));
        learnDataList.add(new LearnData("粉红色", "Pink", 2, R.drawable.color2));
        learnDataList.add(new LearnData("紫色", "Purple", 2, R.drawable.color3));
        learnDataList.add(new LearnData("蓝色", "Blue", 2, R.drawable.color4));
        learnDataList.add(new LearnData("天蓝色", "Sky Blue", 2, R.drawable.color5));
        learnDataList.add(new LearnData("橙色", "Orange", 2, R.drawable.color6));
        learnDataList.add(new LearnData("黄色", "Yellow", 2, R.drawable.color7));
        learnDataList.add(new LearnData("绿色", "Green", 2, R.drawable.color8));
        learnDataList.add(new LearnData("棕色", "Brown", 2, R.drawable.color9));
        learnDataList.add(new LearnData("白色", "White", 2, R.drawable.color10));
        learnDataList.add(new LearnData("灰色", "Gray", 2, R.drawable.color11));
        learnDataList.add(new LearnData("黑色", "Black", 2, R.drawable.color12));
        learnDataList.add(new LearnData("古铜色", "Bronze", 2, R.drawable.color13));
        learnDataList.add(new LearnData("银色", "Silver", 2, R.drawable.color14));
        learnDataList.add(new LearnData("金色", "Gold", 2, R.drawable.color15));
        return learnDataList;
    }

    private static List<LearnData> getFoodData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("筷子", "Chopsticks", 3, R.drawable.food1));
        learnDataList.add(new LearnData("米饭", "Rice", 3, R.drawable.food2));
        learnDataList.add(new LearnData("面条", "Noodles", 3, R.drawable.food3));
        learnDataList.add(new LearnData("面包", "Bread", 3, R.drawable.food4));
        learnDataList.add(new LearnData("鸡蛋", "Egg", 3, R.drawable.food5));
        learnDataList.add(new LearnData("鱼", "Fish", 3, R.drawable.food6));
        learnDataList.add(new LearnData("海鲜", "Seafood", 3, R.drawable.food7));
        learnDataList.add(new LearnData("肉", "Meat", 3, R.drawable.food8));
        learnDataList.add(new LearnData("汤", "Soup", 3, R.drawable.food9));
        learnDataList.add(new LearnData("春卷", "Spring Rolls", 3, R.drawable.food10));
        learnDataList.add(new LearnData("寿司", "Sushi", 3, R.drawable.food11));
        learnDataList.add(new LearnData("沙拉", "Salad", 3, R.drawable.food12));
        learnDataList.add(new LearnData("豆腐", "Tofu", 3, R.drawable.food13));
        learnDataList.add(new LearnData("酱油", "Soy Sauce", 3, R.drawable.food14));
        learnDataList.add(new LearnData("糖醋汁", "Sweet and Sour Sauce", 3, R.drawable.food15));
        learnDataList.add(new LearnData("汤圆", "Sweet Dumpling", 3, R.drawable.food16));
        learnDataList.add(new LearnData("香料", "Spices", 3, R.drawable.food17));
        learnDataList.add(new LearnData("汉堡", "Hamburger", 3, R.drawable.food18));
        learnDataList.add(new LearnData("热狗", "Hot Dog", 3, R.drawable.food19));
        learnDataList.add(new LearnData("披萨", "Pizza", 3, R.drawable.food20));
        learnDataList.add(new LearnData("三明治", "Sandwich", 3, R.drawable.food21));
        learnDataList.add(new LearnData("薯条", "French Fries", 3, R.drawable.food22));
        return learnDataList;
    }

    private static List<LearnData> getVegetableData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("生菜", "Lettuce", 4, R.drawable.vegetable1));
        learnDataList.add(new LearnData("胡萝卜", "Carrot", 4, R.drawable.vegetable2));
        learnDataList.add(new LearnData("萝卜", "Radish", 4, R.drawable.vegetable3));
        learnDataList.add(new LearnData("茄子", "Eggplant", 4, R.drawable.vegetable4));
        learnDataList.add(new LearnData("辣椒", "Chili Pepper", 4, R.drawable.vegetable5));
        learnDataList.add(new LearnData("玉米", "Corn", 4, R.drawable.vegetable6));
        learnDataList.add(new LearnData("番茄", "Tomato", 4, R.drawable.vegetable7));
        learnDataList.add(new LearnData("马铃薯", "Potato", 4, R.drawable.vegetable8));
        learnDataList.add(new LearnData("洋葱", "Onion", 4, R.drawable.vegetable9));
        learnDataList.add(new LearnData("蚕豆", "Broad Bean", 4, R.drawable.vegetable10));
        learnDataList.add(new LearnData("蘑菇", "Mushroom", 4, R.drawable.vegetable11));
        learnDataList.add(new LearnData("南瓜", "Pumpkin", 4, R.drawable.vegetable12));
        learnDataList.add(new LearnData("黄瓜", "Cucumber", 4, R.drawable.vegetable13));
        learnDataList.add(new LearnData("姜", "Ginger", 4, R.drawable.vegetable14));
        learnDataList.add(new LearnData("大豆", "Soybean", 4, R.drawable.vegetable15));
        return learnDataList;
    }

    private static List<LearnData> getFruitData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("香蕉", "Banana", 5, R.drawable.fruit1));
        learnDataList.add(new LearnData("苹果", "Apple", 5, R.drawable.fruit2));
        learnDataList.add(new LearnData("柠檬", "Lemon", 5, R.drawable.fruit3));
        learnDataList.add(new LearnData("椰子", "Coconut", 5, R.drawable.fruit4));
        learnDataList.add(new LearnData("葡萄", "Grape", 5, R.drawable.fruit5));
        learnDataList.add(new LearnData("樱桃", "Cherry", 5, R.drawable.fruit6));
        learnDataList.add(new LearnData("橙子", "Orange", 5, R.drawable.fruit7));
        learnDataList.add(new LearnData("梨", "Pear", 5, R.drawable.fruit8));
        learnDataList.add(new LearnData("草莓", "Strawberry", 5, R.drawable.fruit9));
        learnDataList.add(new LearnData("金桔", "Kumquat", 5, R.drawable.fruit10));
        learnDataList.add(new LearnData("西瓜", "Watermelon", 5, R.drawable.fruit11));
        learnDataList.add(new LearnData("桃子", "Peach", 5, R.drawable.fruit12));
        learnDataList.add(new LearnData("青柠", "Lime", 5, R.drawable.fruit13));
        learnDataList.add(new LearnData("猕猴桃", "Kiwi", 5, R.drawable.fruit14));
        learnDataList.add(new LearnData("山竹", "Mangosteen", 5, R.drawable.fruit15));
        learnDataList.add(new LearnData("哈密瓜", "Cantaloupe", 5, R.drawable.fruit16));
        learnDataList.add(new LearnData("黑莓", "Blackberry", 5, R.drawable.fruit17));
        learnDataList.add(new LearnData("无花果", "Fig", 5, R.drawable.fruit18));
        learnDataList.add(new LearnData("石榴", "Pomegranate", 5, R.drawable.fruit19));
        learnDataList.add(new LearnData("火龙果", "Dragon Fruit", 5, R.drawable.fruit20));
        learnDataList.add(new LearnData("杨桃", "Star Fruit", 5, R.drawable.fruit21));
        return learnDataList;
    }

    private static List<LearnData> getDrinksData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("水", "Water", 6, R.drawable.drink1));
        learnDataList.add(new LearnData("牛奶", "Milk", 6, R.drawable.drink2));
        learnDataList.add(new LearnData("咖啡", "Coffee", 6, R.drawable.drink3));
        learnDataList.add(new LearnData("茶", "Tea", 6, R.drawable.drink4));
        learnDataList.add(new LearnData("果汁", "Juice", 6, R.drawable.drink5));
        learnDataList.add(new LearnData("蜂蜜", "Honey", 6, R.drawable.drink6));
        learnDataList.add(new LearnData("冰淇淋", "Ice Cream", 6, R.drawable.drink7));
        learnDataList.add(new LearnData("果冻", "Jelly", 6, R.drawable.drink8));
        learnDataList.add(new LearnData("糖果", "Sugar", 6, R.drawable.drink9));
        learnDataList.add(new LearnData("冰糖葫芦", "Candied Haws", 6, R.drawable.drink10));
        learnDataList.add(new LearnData("蛋糕", "Cake", 6, R.drawable.drink11));
        return learnDataList;
    }

    private static List<LearnData> getFamilyData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("爷爷", "Grandfather", 7, R.drawable.family6));
        learnDataList.add(new LearnData("奶奶", "Grandmother", 7, R.drawable.family8));
        learnDataList.add(new LearnData("外公", "Grandfather", 7, R.drawable.family7));
        learnDataList.add(new LearnData("外婆", "Grandmother", 7, R.drawable.family9));
        learnDataList.add(new LearnData("爸爸", "Father", 7, R.drawable.people_man));
        learnDataList.add(new LearnData("妈妈", "Mother", 7, R.drawable.people_woman));
        learnDataList.add(new LearnData("哥哥", "Brother", 7, R.drawable.ic_people_boy));
        learnDataList.add(new LearnData("姐姐", "Sister", 7, R.drawable.ic_people_girl));
        learnDataList.add(new LearnData("弟弟", "Brother", 7, R.drawable.family4));
        learnDataList.add(new LearnData("妹妹", "Sister", 7, R.drawable.family5));
        return learnDataList;
    }

    private static List<LearnData> getWildAnimalData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("老虎", "Tiger", 8, R.drawable.wildanimal1));
        learnDataList.add(new LearnData("狮子", "Lion", 8, R.drawable.wildanimal2));
        learnDataList.add(new LearnData("河马", "Hippopotamus", 8, R.drawable.wildanimal3));
        learnDataList.add(new LearnData("犀牛", "Rhinoceros", 8, R.drawable.wildanimal4));
        learnDataList.add(new LearnData("大象", "Elephant", 8, R.drawable.wildanimal5));
        learnDataList.add(new LearnData("猴子", "Monkey", 8, R.drawable.wildanimal6));
        learnDataList.add(new LearnData("猎豹", "Cheetah", 8, R.drawable.wildanimal7));
        learnDataList.add(new LearnData("长颈鹿", "Giraffe", 8, R.drawable.wildanimal8));
        learnDataList.add(new LearnData("袋鼠", "Kangaroo", 8, R.drawable.wildanimal9));
        learnDataList.add(new LearnData("斑马", "Zebra", 8, R.drawable.wildanimal10));
        learnDataList.add(new LearnData("熊", "Bear", 8, R.drawable.wildanimal11));
        learnDataList.add(new LearnData("松鼠", "Squirrel", 8, R.drawable.wildanimal12));
        learnDataList.add(new LearnData("豹", "Leopard", 8, R.drawable.wildanimal13));
        learnDataList.add(new LearnData("狼", "Wolf", 8, R.drawable.wildanimal14));
        learnDataList.add(new LearnData("鹿", "Deer", 8, R.drawable.wildanimal15));
        learnDataList.add(new LearnData("骆驼", "Camel", 8, R.drawable.wildanimal16));
        learnDataList.add(new LearnData("熊猫", "Panda", 8, R.drawable.wildanimal17));
        learnDataList.add(new LearnData("蛇", "Snake", 8, R.drawable.wildanimal18));
        learnDataList.add(new LearnData("鳄鱼", "Crocodile", 8, R.drawable.wildanimal19));
        learnDataList.add(new LearnData("青蛙", "Frog", 8, R.drawable.wildanimal20));
        return learnDataList;
    }

    private static List<LearnData> getFarmAnimalData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("公鸡", "Rooster", 9, R.drawable.farmanimal1));
        learnDataList.add(new LearnData("母鸡", "Hen", 9, R.drawable.farmanimal2));
        learnDataList.add(new LearnData("小鸡", "Chick", 9, R.drawable.farmanimal3));
        learnDataList.add(new LearnData("猪", "Pig", 9, R.drawable.farmanimal4));
        learnDataList.add(new LearnData("绵羊", "Sheep", 9, R.drawable.farmanimal5));
        learnDataList.add(new LearnData("小羊", "Lamb", 9, R.drawable.farmanimal6));
        learnDataList.add(new LearnData("马", "Horse", 9, R.drawable.farmanimal7));
        learnDataList.add(new LearnData("驴子", "Donkey", 9, R.drawable.farmanimal8));
        learnDataList.add(new LearnData("鸭子", "Duck", 9, R.drawable.farmanimal9));
        learnDataList.add(new LearnData("山羊", "Goat", 9, R.drawable.farmanimal10));
        learnDataList.add(new LearnData("牛", "Cow", 9, R.drawable.farmanimal11));
        learnDataList.add(new LearnData("公牛", "Bull", 9, R.drawable.farmanimal12));
        return learnDataList;
    }

    private static List<LearnData> getSeaAnimalData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("鲸", "Whale", 10, R.drawable.seanimals1));
        learnDataList.add(new LearnData("水母", "Jellyfish", 10, R.drawable.seanimals2));
        learnDataList.add(new LearnData("螃蟹", "Crab", 10, R.drawable.seanimals3));
        learnDataList.add(new LearnData("章鱼", "Octopus", 10, R.drawable.seanimals4));
        learnDataList.add(new LearnData("鱿鱼", "Squid", 10, R.drawable.seanimals5));
        learnDataList.add(new LearnData("企鹅", "Penguin", 10, R.drawable.seanimals6));
        learnDataList.add(new LearnData("鲨鱼", "Shark", 10, R.drawable.seanimals7));
        learnDataList.add(new LearnData("海豚", "Dolphin", 10, R.drawable.seanimals8));
        learnDataList.add(new LearnData("珊瑚", "Coral", 10, R.drawable.seanimals9));
        learnDataList.add(new LearnData("海豹", "Seal", 10, R.drawable.seanimals10));
        learnDataList.add(new LearnData("海象", "Walrus", 10, R.drawable.seanimals11));
        learnDataList.add(new LearnData("海马", "Seahorse", 10, R.drawable.seanimals12));
        learnDataList.add(new LearnData("海星", "Starfish", 10, R.drawable.seanimals13));
        learnDataList.add(new LearnData("牡蛎", "Oyster", 10, R.drawable.seanimals14));
        learnDataList.add(new LearnData("龙虾", "Lobster", 10, R.drawable.seanimals15));
        return learnDataList;
    }

    private static List<LearnData> getPetData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("猫", "Cat", 11, R.drawable.pet1));
        learnDataList.add(new LearnData("狗", "Dog", 11, R.drawable.pet2));
        learnDataList.add(new LearnData("鸟", "Bird", 11, R.drawable.pet3));
        learnDataList.add(new LearnData("鱼", "Fish", 11, R.drawable.pet4));
        learnDataList.add(new LearnData("老鼠", "Mouse", 11, R.drawable.pet5));
        learnDataList.add(new LearnData("龟", "Turtle", 11, R.drawable.pet6));
        learnDataList.add(new LearnData("鹦鹉", "Parrot", 11, R.drawable.pet7));
        learnDataList.add(new LearnData("兔子", "Rabbit", 11, R.drawable.pet8));
        return learnDataList;
    }

    private static List<LearnData> getInsectData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("蚂蚁", "Ant", 12, R.drawable.insect1));
        learnDataList.add(new LearnData("瓢虫", "Ladybug", 12, R.drawable.insect2));
        learnDataList.add(new LearnData("蝴蝶", "Butterfly", 12, R.drawable.insect3));
        learnDataList.add(new LearnData("蜜蜂", "Bee", 12, R.drawable.insect4));
        learnDataList.add(new LearnData("草蜢", "Grasshopper", 12, R.drawable.insect5));
        learnDataList.add(new LearnData("蠕虫", "Worm", 12, R.drawable.insect6));
        learnDataList.add(new LearnData("蚊子", "Mosquito", 12, R.drawable.insect7));
        learnDataList.add(new LearnData("苍蝇", "Fly", 12, R.drawable.insect8));
        return learnDataList;
    }

    private static List<LearnData> getTransportationData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("自行车", "Bicycle", 13, R.drawable.tran1));
        learnDataList.add(new LearnData("火车", "Train", 13, R.drawable.tran2));
        learnDataList.add(new LearnData("汽车", "Car", 13, R.drawable.tran3));
        learnDataList.add(new LearnData("轮船", "Ship", 13, R.drawable.tran4));
        learnDataList.add(new LearnData("飞机", "Airplane", 13, R.drawable.tran5));
        learnDataList.add(new LearnData("摩托车", "Motorcycle", 13, R.drawable.tran6));
        learnDataList.add(new LearnData("卡车", "Truck", 13, R.drawable.tran7));
        learnDataList.add(new LearnData("大巴车", "Bus", 13, R.drawable.tran8));
        learnDataList.add(new LearnData("直升机", "Helicopter", 13, R.drawable.tran9));
        learnDataList.add(new LearnData("地铁", "Subway", 13, R.drawable.tran10));
        learnDataList.add(new LearnData("小船", "Boat", 13, R.drawable.tran11));
        learnDataList.add(new LearnData("货车", "Freight Truck", 13, R.drawable.tran12));
        learnDataList.add(new LearnData("挖掘机", "Excavator", 13, R.drawable.tran13));
        learnDataList.add(new LearnData("救护车", "Ambulance", 13, R.drawable.tran14));
        learnDataList.add(new LearnData("潜艇", "Submarine", 13, R.drawable.tran15));
        learnDataList.add(new LearnData("消防车", "Fire Engine", 13, R.drawable.tran16));
        learnDataList.add(new LearnData("热气球", "Hot Air Balloon", 13, R.drawable.tran17));
        learnDataList.add(new LearnData("房车", "Motor Home", 13, R.drawable.tran18));
        return learnDataList;
    }

    private static List<LearnData> getMusicData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("吉他", "Guitar", 14, R.drawable.musical_instrument1));
        learnDataList.add(new LearnData("钢琴", "Piano", 14, R.drawable.musical_instrument2));
        learnDataList.add(new LearnData("爵士鼓", "Jazz Drum", 14, R.drawable.musical_instrument3));
        learnDataList.add(new LearnData("萨克斯风", "Saxophone", 14, R.drawable.musical_instrument4));
        learnDataList.add(new LearnData("竖琴", "Harp", 14, R.drawable.musical_instrument5));
        learnDataList.add(new LearnData("小提琴", "Violin", 14, R.drawable.musical_instrument6));
        learnDataList.add(new LearnData("手风琴", "Accordion", 14, R.drawable.musical_instrument7));
        learnDataList.add(new LearnData("小号", "Trumpet", 14, R.drawable.musical_instrument8));
        learnDataList.add(new LearnData("笛子", "Flute", 14, R.drawable.musical_instrument9));
        learnDataList.add(new LearnData("单簧管", "Clarinet", 14, R.drawable.musical_instrument10));
        learnDataList.add(new LearnData("木琴", "Xylophone", 14, R.drawable.musical_instrument11));
        learnDataList.add(new LearnData("长号", "Trombone", 14, R.drawable.musical_instrument12));
        learnDataList.add(new LearnData("麦克风", "Microphone", 14, R.drawable.musical_instrument13));
        learnDataList.add(new LearnData("音响", "Speaker", 14, R.drawable.musical_instrument14));
        learnDataList.add(new LearnData("音符", "Musical Note", 14, R.drawable.musical_instrument15));
        return learnDataList;
    }

    private static List<LearnData> getWeekData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("星期一", "Monday", 15, R.drawable.daysweek1));
        learnDataList.add(new LearnData("星期二", "Tuesday", 15, R.drawable.daysweek2));
        learnDataList.add(new LearnData("星期三", "Wednesday", 15, R.drawable.daysweek3));
        learnDataList.add(new LearnData("星期四", "Thursday", 15, R.drawable.daysweek4));
        learnDataList.add(new LearnData("星期五", "Friday", 15, R.drawable.daysweek5));
        learnDataList.add(new LearnData("星期六", "Saturday", 15, R.drawable.daysweek6));
        learnDataList.add(new LearnData("星期日", "Sunday", 15, R.drawable.daysweek7));
        return learnDataList;
    }

    private static List<LearnData> getMonthData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("一月", "January", 16, R.drawable.month1));
        learnDataList.add(new LearnData("二月", "February", 16, R.drawable.month2));
        learnDataList.add(new LearnData("三月", "March", 16, R.drawable.month3));
        learnDataList.add(new LearnData("四月", "April", 16, R.drawable.month4));
        learnDataList.add(new LearnData("五月", "May", 16, R.drawable.month5));
        learnDataList.add(new LearnData("六月", "June", 16, R.drawable.month6));
        learnDataList.add(new LearnData("七月", "July", 16, R.drawable.month7));
        learnDataList.add(new LearnData("八月", "August", 16, R.drawable.month8));
        learnDataList.add(new LearnData("九月", "September", 16, R.drawable.month9));
        learnDataList.add(new LearnData("十月", "October", 16, R.drawable.month10));
        learnDataList.add(new LearnData("十一月", "November", 16, R.drawable.month11));
        learnDataList.add(new LearnData("十二月", "December", 16, R.drawable.month12));
        return learnDataList;
    }

    private static List<LearnData> getSeasonData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("春天", "Spring", 17, R.drawable.season1));
        learnDataList.add(new LearnData("夏天", "Summer", 17, R.drawable.season2));
        learnDataList.add(new LearnData("秋天", "Autumn", 17, R.drawable.season3));
        learnDataList.add(new LearnData("冬天", "Winter", 17, R.drawable.season4));
        return learnDataList;
    }

    private static List<LearnData> getWeatherData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("太阳", "Sun", 18, R.drawable.weather1));
        learnDataList.add(new LearnData("云", "Cloud", 18, R.drawable.weather2));
        learnDataList.add(new LearnData("雨", "Rain", 18, R.drawable.weather3));
        learnDataList.add(new LearnData("雪", "Snow", 18, R.drawable.weather4));
        learnDataList.add(new LearnData("暴风", "Storm", 18, R.drawable.weather5));
        learnDataList.add(new LearnData("闪电", "Lightning", 18, R.drawable.weather6));
        learnDataList.add(new LearnData("雷", "Thunder", 18, R.drawable.weather7));
        learnDataList.add(new LearnData("冰雹", "Hail", 18, R.drawable.weather8));
        learnDataList.add(new LearnData("风", "Wind", 18, R.drawable.weather9));
        learnDataList.add(new LearnData("雾", "Fog", 18, R.drawable.weather10));
        learnDataList.add(new LearnData("彩虹", "Rainbow", 18, R.drawable.weather11));
        learnDataList.add(new LearnData("龙卷风", "Tornado", 18, R.drawable.weather12));
        learnDataList.add(new LearnData("热", "Heat", 18, R.drawable.weather13));
        learnDataList.add(new LearnData("暖", "Warm", 18, R.drawable.weather14));
        learnDataList.add(new LearnData("冷", "Cold", 18, R.drawable.weather15));
        return learnDataList;
    }

    private static List<LearnData> getSchoolData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("教室", "Classroom", 19, R.drawable.school1));
        learnDataList.add(new LearnData("学生", "Student", 19, R.drawable.school2));
        learnDataList.add(new LearnData("老师", "Teacher", 19, R.drawable.school3));
        learnDataList.add(new LearnData("铅笔", "Pencil", 19, R.drawable.school4));
        learnDataList.add(new LearnData("笔", "Pen", 19, R.drawable.school5));
        learnDataList.add(new LearnData("橡皮擦", "Eraser", 19, R.drawable.school6));
        learnDataList.add(new LearnData("铅笔刀", "Pencil Sharpener", 19, R.drawable.school7));
        learnDataList.add(new LearnData("黑板", "Blackboard", 19, R.drawable.school8));
        learnDataList.add(new LearnData("尺", "Ruler", 19, R.drawable.school9));
        learnDataList.add(new LearnData("计算器", "Calculator", 19, R.drawable.school10));
        learnDataList.add(new LearnData("荧光笔", "Highlighter", 19, R.drawable.school11));
        learnDataList.add(new LearnData("纸", "Paper", 19, R.drawable.school12));
        learnDataList.add(new LearnData("文件夹", "Folder", 19, R.drawable.school13));
        learnDataList.add(new LearnData("书", "Book", 19, R.drawable.school14));
        learnDataList.add(new LearnData("笔记本", "Notebook", 19, R.drawable.school15));
        learnDataList.add(new LearnData("书包", "Schoolbag", 19, R.drawable.school16));
        learnDataList.add(new LearnData("剪刀", "Scissors", 19, R.drawable.school17));
        learnDataList.add(new LearnData("胶水", "Glue", 19, R.drawable.school18));
        learnDataList.add(new LearnData("圆规", "Compass", 19, R.drawable.school19));
        learnDataList.add(new LearnData("考试", "Exam", 19, R.drawable.school20));
        learnDataList.add(new LearnData("地图", "Map", 19, R.drawable.school21));
        return learnDataList;
    }

    private static List<LearnData> getHumanBodyData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("头", "Head", 20, R.drawable.body1));
        learnDataList.add(new LearnData("头发", "Hair", 20, R.drawable.body2));
        learnDataList.add(new LearnData("眼睛", "Eye", 20, R.drawable.body3));
        learnDataList.add(new LearnData("耳朵", "Ear", 20, R.drawable.body4));
        learnDataList.add(new LearnData("鼻子", "Nose", 20, R.drawable.body5));
        learnDataList.add(new LearnData("嘴巴", "Mouth", 20, R.drawable.body6));
        learnDataList.add(new LearnData("牙齿", "Tooth", 20, R.drawable.body7));
        learnDataList.add(new LearnData("脖子", "Neck", 20, R.drawable.body8));
        learnDataList.add(new LearnData("手臂", "Arm", 20, R.drawable.body9));
        learnDataList.add(new LearnData("肩膀", "Shoulder", 20, R.drawable.body10));
        learnDataList.add(new LearnData("手肘", "Elbow", 20, R.drawable.body11));
        learnDataList.add(new LearnData("手", "Hand", 20, R.drawable.body12));
        learnDataList.add(new LearnData("手指", "Finger", 20, R.drawable.body13));
        learnDataList.add(new LearnData("腿", "Leg", 20, R.drawable.body14));
        learnDataList.add(new LearnData("膝盖", "Knee", 20, R.drawable.body15));
        learnDataList.add(new LearnData("脚踝", "Ankle", 20, R.drawable.body16));
        learnDataList.add(new LearnData("脚", "Foot", 20, R.drawable.body17));
        learnDataList.add(new LearnData("脚趾", "Toe", 20, R.drawable.body18));
        return learnDataList;
    }

    private static List<LearnData> getClothingData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("T恤", "T-Shirt", 21, R.drawable.clothes1));
        learnDataList.add(new LearnData("毛衣", "Sweater", 21, R.drawable.clothes2));
        learnDataList.add(new LearnData("夹克", "Jacket", 21, R.drawable.clothes3));
        learnDataList.add(new LearnData("长裤", "Trousers", 21, R.drawable.clothes4));
        learnDataList.add(new LearnData("牛仔裤", "Jeans", 21, R.drawable.clothes5));
        learnDataList.add(new LearnData("睡衣", "Pajamas", 21, R.drawable.clothes6));
        learnDataList.add(new LearnData("裙子", "Skirt", 21, R.drawable.clothes7));
        learnDataList.add(new LearnData("西装", "Suit", 21, R.drawable.clothes8));
        learnDataList.add(new LearnData("鞋", "Shoes", 21, R.drawable.clothes9));
        learnDataList.add(new LearnData("球鞋", "Sneakers", 21, R.drawable.clothes10));
        learnDataList.add(new LearnData("袜子", "Socks", 21, R.drawable.clothes11));
        learnDataList.add(new LearnData("围巾", "Scarf", 21, R.drawable.clothes12));
        learnDataList.add(new LearnData("皮带", "Belt", 21, R.drawable.clothes13));
        learnDataList.add(new LearnData("手套", "Gloves", 21, R.drawable.clothes14));
        learnDataList.add(new LearnData("眼镜", "Glasses", 21, R.drawable.clothes15));
        learnDataList.add(new LearnData("帽子", "Hat", 21, R.drawable.clothes16));
        learnDataList.add(new LearnData("领带", "Tie", 21, R.drawable.clothes17));
        learnDataList.add(new LearnData("衬衫", "Shirt", 21, R.drawable.clothes18));
        learnDataList.add(new LearnData("内衣", "Underwear", 21, R.drawable.clothes19));
        learnDataList.add(new LearnData("短裤", "Shorts", 21, R.drawable.clothes20));
        return learnDataList;
    }

    private static List<LearnData> getHolidayData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("海滩", "Beach", 22, R.drawable.holidays1));
        learnDataList.add(new LearnData("沙堡", "Sandcastle", 22, R.drawable.holidays2));
        learnDataList.add(new LearnData("墨镜", "Sunglasses", 22, R.drawable.holidays3));
        learnDataList.add(new LearnData("阳伞", "Sun Umbrella", 22, R.drawable.holidays4));
        learnDataList.add(new LearnData("球", "Ball", 22, R.drawable.holidays5));
        learnDataList.add(new LearnData("棕榈树", "Palm Tree", 22, R.drawable.holidays6));
        learnDataList.add(new LearnData("躺椅", "Lounge Chair", 22, R.drawable.holidays7));
        learnDataList.add(new LearnData("游泳池", "Swimming Pool", 22, R.drawable.holidays8));
        learnDataList.add(new LearnData("行李", "Luggage", 22, R.drawable.holidays9));
        learnDataList.add(new LearnData("防晒霜", "Sunscreen", 22, R.drawable.holidays10));
        return learnDataList;
    }

    private static List<LearnData> getPhysicalData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("足球", "Football", 23, R.drawable.sport1));
        learnDataList.add(new LearnData("游泳", "Swimming", 23, R.drawable.sport2));
        learnDataList.add(new LearnData("排球", "Volleyball", 23, R.drawable.sport3));
        learnDataList.add(new LearnData("篮球", "Basketball", 23, R.drawable.sport4));
        learnDataList.add(new LearnData("网球", "Tennis", 23, R.drawable.sport5));
        learnDataList.add(new LearnData("棒球", "Baseball", 23, R.drawable.sport6));
        learnDataList.add(new LearnData("橄榄球", "American Football", 23, R.drawable.sport7));
        learnDataList.add(new LearnData("滑雪", "Skiing", 23, R.drawable.sport8));
        learnDataList.add(new LearnData("高尔夫球", "Golf", 23, R.drawable.sport9));
        learnDataList.add(new LearnData("保龄球", "Bowling", 23, R.drawable.sport10));
        learnDataList.add(new LearnData("田径", "Athletics", 23, R.drawable.sport11));
        return learnDataList;
    }

    private static List<LearnData> getCityData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("街", "Street", 24, R.drawable.city1));
        learnDataList.add(new LearnData("斑马线", "Zebra Crossing", 24, R.drawable.city2));
        learnDataList.add(new LearnData("红绿灯", "Traffic Light", 24, R.drawable.city3));
        learnDataList.add(new LearnData("路灯", "Street Lamp", 24, R.drawable.city4));
        learnDataList.add(new LearnData("长凳", "Bench", 24, R.drawable.city5));
        learnDataList.add(new LearnData("标志", "Sign", 24, R.drawable.city6));
        learnDataList.add(new LearnData("邮箱", "Mailbox", 24, R.drawable.city7));
        learnDataList.add(new LearnData("电话亭", "Telephone Booth", 24, R.drawable.city8));
        learnDataList.add(new LearnData("公车站", "Bus Stop", 24, R.drawable.city9));
        learnDataList.add(new LearnData("建筑物", "Building", 24, R.drawable.city10));
        learnDataList.add(new LearnData("房屋", "House", 24, R.drawable.city11));
        learnDataList.add(new LearnData("喷泉", "Fountain", 24, R.drawable.city12));
        return learnDataList;
    }

    private static List<LearnData> getBedroomData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("床", "Bed", 25, R.drawable.bedroom1));
        learnDataList.add(new LearnData("枕头", "Pillow", 25, R.drawable.bedroom2));
        learnDataList.add(new LearnData("毯子", "Blanket", 25, R.drawable.bedroom3));
        learnDataList.add(new LearnData("衣柜", "Wardrobe", 25, R.drawable.bedroom4));
        learnDataList.add(new LearnData("衣架", "Hanger", 25, R.drawable.bedroom5));
        learnDataList.add(new LearnData("床头柜", "Bedside Table", 25, R.drawable.bedroom6));
        learnDataList.add(new LearnData("闹钟", "Alarm Clock", 25, R.drawable.bedroom7));
        learnDataList.add(new LearnData("台灯", "Desk Lamp", 25, R.drawable.bedroom8));
        learnDataList.add(new LearnData("书柜", "Bookcase", 25, R.drawable.bedroom9));
        learnDataList.add(new LearnData("椅子", "Chair", 25, R.drawable.bedroom10));
        learnDataList.add(new LearnData("架子", "Shelf", 25, R.drawable.bedroom11));
        learnDataList.add(new LearnData("书桌", "Desk", 25, R.drawable.bedroom12));
        return learnDataList;
    }

    private static List<LearnData> getBathroomData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("马桶", "Toilet", 26, R.drawable.bathroom1));
        learnDataList.add(new LearnData("卫生纸", "Toilet Paper", 26, R.drawable.bathroom2));
        learnDataList.add(new LearnData("洗手盆", "Sink", 26, R.drawable.bathroom3));
        learnDataList.add(new LearnData("水龙头", "Faucet", 26, R.drawable.bathroom4));
        learnDataList.add(new LearnData("肥皂", "Soap", 26, R.drawable.bathroom5));
        learnDataList.add(new LearnData("毛巾", "Towel", 26, R.drawable.bathroom6));
        learnDataList.add(new LearnData("镜子", "Mirror", 26, R.drawable.bathroom7));
        learnDataList.add(new LearnData("淋浴", "Shower", 26, R.drawable.bathroom8));
        learnDataList.add(new LearnData("浴缸", "Bathtub", 26, R.drawable.bathroom9));
        learnDataList.add(new LearnData("牙刷", "Toothbrush", 26, R.drawable.bathroom10));
        learnDataList.add(new LearnData("牙膏", "Toothpaste", 26, R.drawable.bathroom11));
        learnDataList.add(new LearnData("沐浴球", "Loofah", 26, R.drawable.bathroom12));
        return learnDataList;
    }

    private static List<LearnData> getKitchenData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("叉子", "Fork", 27, R.drawable.kitchen1));
        learnDataList.add(new LearnData("刀", "Knife", 27, R.drawable.kitchen2));
        learnDataList.add(new LearnData("汤匙", "Spoon", 27, R.drawable.kitchen3));
        learnDataList.add(new LearnData("盘子", "Plate", 27, R.drawable.kitchen4));
        learnDataList.add(new LearnData("碗", "Bowl", 27, R.drawable.kitchen5));
        learnDataList.add(new LearnData("餐巾", "Napkin", 27, R.drawable.kitchen6));
        learnDataList.add(new LearnData("玻璃杯", "Glass", 27, R.drawable.kitchen7));
        learnDataList.add(new LearnData("杯子", "Cup", 27, R.drawable.kitchen8));
        learnDataList.add(new LearnData("瓶子", "Bottle", 27, R.drawable.kitchen9));
        learnDataList.add(new LearnData("咖啡壶", "Coffee Pot", 27, R.drawable.kitchen10));
        learnDataList.add(new LearnData("平底锅", "Frying Pan", 27, R.drawable.kitchen11));
        learnDataList.add(new LearnData("托盘", "Tray", 27, R.drawable.kitchen12));
        return learnDataList;
    }

    private static List<LearnData> getLivingData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("沙发", "Sofa", 28, R.drawable.livingroom1));
        learnDataList.add(new LearnData("坐垫", "Cushion", 28, R.drawable.livingroom2));
        learnDataList.add(new LearnData("桌子", "Table", 28, R.drawable.livingroom3));
        learnDataList.add(new LearnData("地毯", "Carpet", 28, R.drawable.livingroom4));
        learnDataList.add(new LearnData("扶手椅", "Armchair", 28, R.drawable.livingroom5));
        learnDataList.add(new LearnData("窗户", "Window", 28, R.drawable.livingroom6));
        learnDataList.add(new LearnData("窗帘", "Curtain", 28, R.drawable.livingroom7));
        learnDataList.add(new LearnData("画", "Painting", 28, R.drawable.livingroom8));
        learnDataList.add(new LearnData("壁炉", "Fireplace", 28, R.drawable.livingroom9));
        learnDataList.add(new LearnData("门", "Door", 28, R.drawable.livingroom10));
        learnDataList.add(new LearnData("楼梯", "Stairs", 28, R.drawable.livingroom11));
        learnDataList.add(new LearnData("插座", "Socket", 28, R.drawable.livingroom12));
        return learnDataList;
    }

    private static List<LearnData> getShapeData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("三角形", "Triangle", 29, R.drawable.shape1));
        learnDataList.add(new LearnData("圆形", "Circle", 29, R.drawable.shape2));
        learnDataList.add(new LearnData("长方形", "Rectangle", 29, R.drawable.shape3));
        learnDataList.add(new LearnData("正方形", "Square", 29, R.drawable.shape4));
        learnDataList.add(new LearnData("椭圆形", "Ellipse", 29, R.drawable.shape5));
        learnDataList.add(new LearnData("菱形", "Diamond", 29, R.drawable.shape6));
        learnDataList.add(new LearnData("五边形", "Pentagon", 29, R.drawable.shape7));
        learnDataList.add(new LearnData("六边形", "Hexagon", 29, R.drawable.shape8));
        learnDataList.add(new LearnData("八边形", "Octagon", 29, R.drawable.shape9));
        learnDataList.add(new LearnData("箭头", "Arrow", 29, R.drawable.shape10));
        learnDataList.add(new LearnData("星形", "Star", 29, R.drawable.shape11));
        learnDataList.add(new LearnData("月牙形", "Crescent", 29, R.drawable.shape12));
        learnDataList.add(new LearnData("红心", "Heart", 29, R.drawable.shape13));
        learnDataList.add(new LearnData("圆锥体", "Cone", 29, R.drawable.shape14));
        learnDataList.add(new LearnData("立方体", "Cube", 29, R.drawable.shape15));
        learnDataList.add(new LearnData("圆柱体", "Cylinder", 29, R.drawable.shape16));
        learnDataList.add(new LearnData("球体", "Sphere", 29, R.drawable.shape17));
        return learnDataList;
    }

    private static List<LearnData> getNaturalData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("山", "Mountain", 30, R.drawable.nature1));
        learnDataList.add(new LearnData("火山", "Volcano", 30, R.drawable.nature2));
        learnDataList.add(new LearnData("冰川", "Glacier", 30, R.drawable.nature3));
        learnDataList.add(new LearnData("海", "Sea", 30, R.drawable.nature4));
        learnDataList.add(new LearnData("悬崖", "Cliff", 30, R.drawable.nature5));
        learnDataList.add(new LearnData("森林", "Forest", 30, R.drawable.nature6));
        learnDataList.add(new LearnData("湖", "Lake", 30, R.drawable.nature7));
        learnDataList.add(new LearnData("河", "River", 30, R.drawable.nature8));
        learnDataList.add(new LearnData("平原", "Plain", 30, R.drawable.nature9));
        learnDataList.add(new LearnData("瀑布", "Waterfall", 30, R.drawable.nature10));
        learnDataList.add(new LearnData("岛", "Island", 30, R.drawable.nature11));
        learnDataList.add(new LearnData("路", "Road", 30, R.drawable.nature12));
        return learnDataList;
    }

    private static List<LearnData> getOppositeData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("大", "Big", 31, R.drawable.opposite1));
        learnDataList.add(new LearnData("小", "Small", 31, R.drawable.opposite4));
        learnDataList.add(new LearnData("男孩", "Boy", 31, R.drawable.opposite2));
        learnDataList.add(new LearnData("女孩", "Girl", 31, R.drawable.opposite5));
        learnDataList.add(new LearnData("快", "Fast", 31, R.drawable.opposite3));
        learnDataList.add(new LearnData("慢", "Slow", 31, R.drawable.opposite6));
        learnDataList.add(new LearnData("新", "New", 31, R.drawable.opposite7));
        learnDataList.add(new LearnData("旧", "Old", 31, R.drawable.opposite10));
        learnDataList.add(new LearnData("城市", "City", 31, R.drawable.opposite8));
        learnDataList.add(new LearnData("城镇", "Town", 31, R.drawable.opposite11));
        learnDataList.add(new LearnData("冰", "Ice", 31, R.drawable.opposite9));
        learnDataList.add(new LearnData("火", "Fire", 31, R.drawable.opposite12));
        return learnDataList;
    }

    private static List<LearnData> getVerbData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("吃", "Eat", 32, R.drawable.actionverb5));
        learnDataList.add(new LearnData("喝", "Drink", 32, R.drawable.actionverb3));
        learnDataList.add(new LearnData("睡", "Sleep", 32, R.drawable.actionverb9));
        learnDataList.add(new LearnData("跳", "Jump", 32, R.drawable.actionverb6));
        learnDataList.add(new LearnData("跑", "Run", 32, R.drawable.actionverb7));
        learnDataList.add(new LearnData("唱", "Sing", 32, R.drawable.actionverb8));
        learnDataList.add(new LearnData("哭", "Cry", 32, R.drawable.actionverb2));
        learnDataList.add(new LearnData("画", "Paint", 32, R.drawable.actionverb14));
        learnDataList.add(new LearnData("读", "Read", 32, R.drawable.actionverb16));
        learnDataList.add(new LearnData("写", "Write", 32, R.drawable.actionverb12));
        learnDataList.add(new LearnData("坐", "Sit", 32, R.drawable.actionverb19));
        learnDataList.add(new LearnData("开", "Open", 32, R.drawable.actionverb20));
        learnDataList.add(new LearnData("关", "Close", 32, R.drawable.actionverb21));
        learnDataList.add(new LearnData("切", "Cut", 32, R.drawable.actionverb22));
        learnDataList.add(new LearnData("洗", "Wash", 32, R.drawable.actionverb15));
        learnDataList.add(new LearnData("游泳", "Swim", 32, R.drawable.actionverb10));
        learnDataList.add(new LearnData("走路", "Walk", 32, R.drawable.actionverb11));
        learnDataList.add(new LearnData("驾驶", "Drive", 32, R.drawable.actionverb4));
        learnDataList.add(new LearnData("清洁", "Clean", 32, R.drawable.actionverb13));
        learnDataList.add(new LearnData("做饭", "Cook", 32, R.drawable.actionverb1));
        learnDataList.add(new LearnData("工作", "Work", 32, R.drawable.actionverb18));
        learnDataList.add(new LearnData("舞蹈", "Dance", 32, R.drawable.actionverb23));
        learnDataList.add(new LearnData("做梦", "Dream", 32, R.drawable.actionverb24));
        learnDataList.add(new LearnData("打电话", "Call", 32, R.drawable.actionverb17));
        return learnDataList;
    }

    private static List<LearnData> getScienceData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("相机", "Camera", 33, R.drawable.tech1));
        learnDataList.add(new LearnData("光碟", "CD", 33, R.drawable.tech2));
        learnDataList.add(new LearnData("电脑", "Computer", 33, R.drawable.tech3));
        learnDataList.add(new LearnData("笔记本电脑", "Laptop", 33, R.drawable.tech4));
        learnDataList.add(new LearnData("游戏机", "Game Console", 33, R.drawable.tech5));
        learnDataList.add(new LearnData("手机", "Mobile Phone", 33, R.drawable.tech6));
        learnDataList.add(new LearnData("耳机", "Headphones", 33, R.drawable.tech7));
        learnDataList.add(new LearnData("收音机", "Radio", 33, R.drawable.tech8));
        learnDataList.add(new LearnData("电池", "Battery", 33, R.drawable.tech9));
        return learnDataList;
    }

    private static List<LearnData> getElectricalData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("吸尘器", "Vacuum Cleaner", 34, R.drawable.appliance1));
        learnDataList.add(new LearnData("咖啡机", "Coffee Maker", 34, R.drawable.appliance2));
        learnDataList.add(new LearnData("冰箱", "Refrigerator", 34, R.drawable.appliance3));
        learnDataList.add(new LearnData("吹风机", "Hair Dryer", 34, R.drawable.appliance4));
        learnDataList.add(new LearnData("暖气机", "Heater", 34, R.drawable.appliance5));
        learnDataList.add(new LearnData("熨斗", "Iron", 34, R.drawable.appliance6));
        learnDataList.add(new LearnData("微波炉", "Microwave Oven", 34, R.drawable.appliance7));
        learnDataList.add(new LearnData("搅拌机", "Blender", 34, R.drawable.appliance8));
        learnDataList.add(new LearnData("烤箱", "Oven", 34, R.drawable.appliance9));
        learnDataList.add(new LearnData("电视", "Television", 34, R.drawable.appliance10));
        learnDataList.add(new LearnData("吐司机", "Toaster", 34, R.drawable.appliance11));
        learnDataList.add(new LearnData("洗衣机", "Washing Machine", 34, R.drawable.appliance12));
        return learnDataList;
    }

    private static List<LearnData> getOuterData() {
        List<LearnData> learnDataList = new ArrayList<>();
        learnDataList.add(new LearnData("太空船", "Spaceship", 35, R.drawable.space1));
        learnDataList.add(new LearnData("行星", "Planet", 35, R.drawable.space2));
        learnDataList.add(new LearnData("地球", "Earth", 35, R.drawable.space3));
        learnDataList.add(new LearnData("月亮", "Moon", 35, R.drawable.space4));
        learnDataList.add(new LearnData("小行星", "Asteroid", 35, R.drawable.space5));
        learnDataList.add(new LearnData("外星人", "Alien", 35, R.drawable.space6));
        learnDataList.add(new LearnData("星系", "Galaxy", 35, R.drawable.space7));
        learnDataList.add(new LearnData("望远镜", "Telescope", 35, R.drawable.space8));
        return learnDataList;
    }
}