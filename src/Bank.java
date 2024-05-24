public class Bank {
    private User[] users = new User[5];
    private static int userId = 0;

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public void addUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                users[i] = user;
                users[i].setId(++userId);
                return;
            }
        }

        User[] newList = new User[users.length * 2];
        for (int i = 0; i < users.length; i++) {
            newList[i] = users[i];
        }
        newList[users.length] = user;
        newList[users.length].setId(++userId);
        users = newList;
        newList = null;
    }

    public boolean updateUserById(int id, User user) {
        boolean isUpdated = false;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                users[i] = user;
                isUpdated = true;
            }
        }
        return isUpdated;
    }

    public boolean removeUserById(int id) {
        boolean isRemoved = false;

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                User[] newList = new User[users.length - 1];
                for (int j = 0; j < users.length; j++) {
                    if (j != i) {
                        newList[j] = users[i];
                    }
                }
                users = newList;
                newList = null;
                isRemoved = true;
            }
        }

        return isRemoved;
    }

    public User[] getAllUsers() {
        int count = 0;
        for (User user : users) {
            if (user != null) {
                count++;
            }
        }

        if (count == 0) {
            return new User[0];
        }

        User[] newList = new User[count];
        count = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                newList[count] = users[i];
                count++;
            }
        }
        return newList;
    }

    public User getUserById(int id) {
        User user = null;

        for (User bankUser : users) {
            if (bankUser != null && bankUser.getId() == id) {
                user = bankUser;
                break;
            }
        }

        return user;
    }
}
