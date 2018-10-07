package repository;

import model.DrinkList;
import model.Drinks;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class MixMeDBRepo {


    public void persistObject(DrinkList completeDrinkList) throws SQLException {
        //Fill before running
        String host = "";
        String port = "";
        String databaseName = "";
        String userName = "";
        String password = "";
//        String password = "";
        MySQLDBConnect connect = null;
        Connection connection = null;
        try {
            connect = new MySQLDBConnect(host, port, databaseName, userName, password);
            connection = connect.getConnection();
            String insertStatement = "INSERT INTO cocktaildb.drinks " +
                    "(strDrink,idDrink,strDrinkES,strDrinkDE,strDrinkFR,strVideo,strCategory,strIBA,strAlcoholic,strGlass,strInstructions," +
                    "strInstructionsES,strInstructionsDE,strInstructionsFR,strDrinkThumb,strIredient1,strIredient2,strIredient3,strIredient4," +
                    "strIredient5,strIredient6,strIredient7,strIredient8,strIredient9,strIredient10,strIredient11,strIredient12,strIredient13," +
                    "strIredient14,strIredient15,strMeasure1,strMeasure2,strMeasure3,strMeasure4,strMeasure5,strMeasure6,strMeasure7,strMeasure8," +
                    "strMeasure9,strMeasure10,strMeasure11,strMeasure12,strMeasure13,strMeasure14,strMeasure15,dateModified) " +
                    "VALUES " +
                    "(? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? );";
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);

            for (Drinks drinks : completeDrinkList.getDrinks()) {
                preparedStatement.setString(1, drinks.getStrDrink());
                preparedStatement.setString(2, drinks.getIdDrink());
                preparedStatement.setString(3, drinks.getStrDrinkES());
                preparedStatement.setString(4, drinks.getStrDrinkDE());
                preparedStatement.setString(5, drinks.getStrDrinkFR());
                preparedStatement.setString(6, drinks.getStrVideo());
                preparedStatement.setString(7, drinks.getStrCategory());
                preparedStatement.setString(8, drinks.getStrIBA());
                preparedStatement.setString(9, drinks.getStrAlcoholic());
                preparedStatement.setString(10, drinks.getStrGlass());
                preparedStatement.setString(11, drinks.getStrInstructions());
                preparedStatement.setString(12, drinks.getStrInstructionsES());
                preparedStatement.setString(13, drinks.getStrInstructionsDE());
                preparedStatement.setString(14, drinks.getStrInstructionsFR());
                preparedStatement.setString(15, drinks.getStrDrinkThumb());
                preparedStatement.setString(16, drinks.getStrIngredient1());
                preparedStatement.setString(17, drinks.getStrIngredient2());
                preparedStatement.setString(18, drinks.getStrIngredient3());
                preparedStatement.setString(19, drinks.getStrIngredient4());
                preparedStatement.setString(20, drinks.getStrIngredient5());
                preparedStatement.setString(21, drinks.getStrIngredient6());
                preparedStatement.setString(22, drinks.getStrIngredient7());
                preparedStatement.setString(23, drinks.getStrIngredient8());
                preparedStatement.setString(24, drinks.getStrIngredient9());
                preparedStatement.setString(25, drinks.getStrIngredient10());
                preparedStatement.setString(26, drinks.getStrIngredient11());
                preparedStatement.setString(27, drinks.getStrIngredient12());
                preparedStatement.setString(28, drinks.getStrIngredient13());
                preparedStatement.setString(29, drinks.getStrIngredient14());
                preparedStatement.setString(30, drinks.getStrIngredient15());
                preparedStatement.setString(31, drinks.getStrMeasure1());
                preparedStatement.setString(32, drinks.getStrMeasure2());
                preparedStatement.setString(33, drinks.getStrMeasure3());
                preparedStatement.setString(34, drinks.getStrMeasure4());
                preparedStatement.setString(35, drinks.getStrMeasure5());
                preparedStatement.setString(36, drinks.getStrMeasure6());
                preparedStatement.setString(37, drinks.getStrMeasure7());
                preparedStatement.setString(38, drinks.getStrMeasure8());
                preparedStatement.setString(39, drinks.getStrMeasure9());
                preparedStatement.setString(40, drinks.getStrMeasure10());
                preparedStatement.setString(41, drinks.getStrMeasure11());
                preparedStatement.setString(42, drinks.getStrMeasure12());
                preparedStatement.setString(43, drinks.getStrMeasure13());
                preparedStatement.setString(44, drinks.getStrMeasure14());
                preparedStatement.setString(45, drinks.getStrMeasure15());
                preparedStatement.setString(46, drinks.getDateModified());
                preparedStatement.execute();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection !=null && !connection.isClosed()) { // validate conn whether it is null
                connection.close();
            }
        }


    }
}
