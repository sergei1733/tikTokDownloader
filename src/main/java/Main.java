import java.io.IOException;
import java.net.MalformedURLException;


public class Main {
    /*
     * Простой загрузчик тикток на java.
	 * Обратите внимание: при этом будут загружены видео с водяным знаком.
     *
     * Если у вас возникли проблемы с загрузкой видео,
	 * используйте свой браузер на своем компьютере, посетите видео в тикток,
     * и скопируйте ссылку в адресную строку и используйте этот URL для
	 * скачать тикток.
     */

    final String TikTokSaveLocation = "/home/h/Загрузки/TikTok_" + System.currentTimeMillis() + ".mp4";
    final String TikTokURL = "https://www.tiktok.com/@mukhtiar54/video/6938492187365625090";
//    final String TikTokURL = "https://www.tiktok.com/@duncanyounot/video/6752667006530620678";
    final String TikTokURL2 = "https://www.tiktok.com/@jay.gamao/video/6747120899637382402";

    /// Удаляем статический контекст
    public static void main(String[] args) { new Main().mainMethod(); }


    // Основной метод
    public void mainMethod() {

        try {

            // Инициализируем класс TikTokDownloaderV2
            TikTokDownloaderV2 ttd = new TikTokDownloaderV2(TikTokSaveLocation, TikTokURL);
//            TikTokDownloader ttd = new TikTokDownloader();

            // Вызов метода загрузки для загрузки видео
            ttd.download();
//            ttd.download(TikTokURL,File );

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
}
