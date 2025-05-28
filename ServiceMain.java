public class ServiceMain {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        ServiceLinkedList serviceLinkedList = new ServiceLinkedList();


        // NOTE! saat login ada validasi baru, baru bisa lanjut ke Banner()

        loginService.login();
        serviceLinkedList.Banner();
    }
}
