import Model.*;
import View.View;

public enum Command {
    ADD_CATEGORY_OF_FOOD("addCategoryOfFood"){
        @Override
        int processCommand(String[] args, Model model) {
            int n = model.addCategoryOfFood(new CategoryOfFood(args[0]));
            return n;
        }

        @Override
        void updateView(View view, String[] args) {
            view.printLastCategoryOfFood(Integer.parseInt(args[0]));
        }
    },
    GET_ALL_CATEGORY_OF_FOOD("getAllCategoryOfFood"){
        @Override
        int processCommand(String[] args, Model model) {
            return 0;
        }

        @Override
        void updateView(View view, String[] args) {
            view.printAllCategoryOfFood();
        }
    },
    GET_CATEGORY_BY_ID("getCategoryById"){
        @Override
        int processCommand(String[] args, Model model) {
            return 0;
        }

        @Override
        void updateView(View view, String[] args) {
            view.printCategoryById(Integer.parseInt(args[0]));
        }
    },
    ADD_FOOD("addFood"){
        @Override
        int processCommand(String[] args, Model model) {
            int n = model.addFood(new Food(args[0], model.getCategoryOfFoodById(Integer.parseInt(args[1])), Integer.parseInt(args[2])));
            return n;
        }

        @Override
        void updateView(View view, String[] args) {
            view.printLastFood(Integer.parseInt(args[0]));
        }
    },
    GET_FOOD_BY_ID("getFoodById"){
        @Override
        int processCommand(String[] args, Model model) {
            return 0;
        }

        @Override
        void updateView(View view, String[] args) {
            view.printFoodById(Integer.parseInt(args[0]));
        }
    },
    GET_ALL_FOOD("getAllFood"){
        @Override
        int processCommand(String[] args, Model model) {
            return 0;
        }

        @Override
        void updateView(View view, String[] args) {
            view.printAllFood();
        }
    },
    GET_FOOD_BY_CATEGORY_ID("getFoodByCategoryId"){
        @Override
        int processCommand(String[] args, Model model) {
            return 0;
        }

        @Override
        void updateView(View view, String[] args) {
            view.printFoodByCategoryId(Integer.parseInt(args[0]));
        }

    };

    private String commandName;

    Command(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public static Command getCommand(String name) {
        for(Command command: Command.values()){
            if(command.getCommandName().equals(name)){
                return command;
            }
        }
        throw new IllegalArgumentException("Command not found");
    }

    abstract int processCommand(String[] args, Model model);
    abstract void updateView(View view, String[] args);

}
