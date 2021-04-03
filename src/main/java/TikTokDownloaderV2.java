import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class TikTokDownloaderV2 {
    //Set up variables
    private File file;
    private URL url;


//    Этот метод устанавливает переменные, необходимые для загрузки видео.
//	 fileLocation - это место, где будет сохранено видео
//	 videoURL - это URL-адрес загружаемого видео

    public TikTokDownloaderV2(String fileLocation, String videoURL) throws MalformedURLException {
        file = new File(fileLocation);
        url = new URL(videoURL);
        System.out.println("Initialized TikTokDownloader version 2");
    }




//     Этот метод подключается к веб-сайту с заданного URL-адреса.
//     Он удаляет бесполезный контент и захватывает URL-адрес видео и URL-адрес миниатюры
//	 с веб-страницы

    public void download() throws IOException {

        //Создаем URL-соединение
        URLConnection conn = url.openConnection();

        //Устанавливаем пользовательский агент, чтобы TikTok думал, что мы человек, использующий браузер вместо программы
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
//        conn.setRequestProperty("User-Agent", "");

        //Настраиваем bufferedReader
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

         /*
		 * Прочтите каждую строку, пока не получите
		 * в строку с текстом 'videoObject'
         * где разное. информация о
		 * пользователь хранится и где видео
         * URL тоже сохраняется
		 */
        String data;
        while((data = in.readLine()) !=null) {
            if(data.contains("videoObject")) {
                // Читаем до тех пор, пока не дойдем до строки в HTML-файле, обозначенной как 'videoObject'
                break;
            }
        }

        //Закрываем bufferedReader, так как он нам больше не нужен
        in.close();

        /*
		 * Поскольку мы просматриваем необработанный исходный код из
         * веб-сайт, там много мусора, в том числе, но не
         * ограничено тегами HTML, javascript, случайным текстом и т. д.
         * на. Мы этого не хотим. Вот почему он будет обрезан
         * внизу внизу
         */

        //Вырезаем ненужные теги и код за строкой VideoObject
        data = data.substring(data.indexOf("VideoObject"), data.length());


        //Захватываем URL-адрес ногтя большого пальца
        String thumbnailURL = data.substring(data.indexOf("thumbnailUrl") + 16);
        thumbnailURL = thumbnailURL.substring(0, thumbnailURL.indexOf("\""));

        // Распечатать URL-адрес эскиза
        System.out.println("ThumbnailURL: " + thumbnailURL);

        //Захватываем URL-адрес содержимого (видеофайл)
        String contentURL = data.substring(data.indexOf("contentUrl") + 13);
        contentURL = contentURL.substring(0, contentURL.indexOf("?"));

        //Распечатать URL-адрес видео
        System.out.println("ContentURL: " + contentURL);

        //Теперь, когда у нас есть эскиз и URL видео, мы можем их скачать!
        downloadVideoFile(contentURL);
    }


    /*
            * Этот метод фактически загружает видео
	 */
    private void downloadVideoFile(String url) throws MalformedURLException, IOException {
        url = "https://www.tiktok.com/@mukhtiar54/video/6938492187365625090,robotsContent:index, follow,applicableDevice:pc, mobile},videoObject:{},jsonldList:[[VideoObject,{}],[Breadcrumb,null]]},$language:en,statusCode:0,statusMsg:,itemInfo:{itemStruct:{id:6938492187365625090,desc:#tiktokqatar #foryoupage #summerlife #riverside,createTime:1615493609,scheduleTime:0,video:{id:6938492187365625090,height:576,width:1024,duration:15,ratio:720p,cover:https://p16-sign-sg.tiktokcdn.com/obj/tos-alisg-p-0037/f926701071444639aa0888bc920ae863";
        url = "[Breadcrumb,null]]},$language:en,statusCode:0,statusMsg:,itemInfo:{itemStruct:{id:6938492187365625090,desc:#tiktokqatar #foryoupage #summerlife #riverside,createTime:1615493609,scheduleTime:0,video:{id:6938492187365625090,height:576,width:1024,duration:15,ratio:720p,cover:https://p16-sign-sg.tiktokcdn.com/obj/tos-alisg-p-0037/f926701071444639aa0888bc920ae863";
        url = "https://v16-web.tiktok.com/video/tos/alisg/tos-alisg-pve-0037c001/17706f74a1ab4d8c852589e8f0edbe15/?a=1988\\u0026br=4120\\u0026bt=2060\\u0026cd=0%7C0%7C1\\u0026ch=0\\u0026cr=0\\u0026cs=0\\u0026cv=1\\u0026dr=0\\u0026ds=3\\u0026er=\\u0026expire=1617463586\\u0026l=202104030926110101901851523881FDC4\\u0026lr=tiktok_m\\u0026mime_type=video_mp4\\u0026net=0\\u0026pl=0\\u0026policy=2\\u0026qs=0\\u0026rc=M21vbTk7Z3E6NDMzNjczM0ApM2g5NzRpNTtnN2Q3NTU4OWdtNmcvbHNhZzJgLS1hMTRzczQyXy0zYy81Y2FgL2JeYmE6Yw%3D%3D\\u0026signature=a37adf90fe7a785d857f8e7840e0772e\\u0026tk=tt_webid_v2\\u0026vl=\\u0026vr=";
        url = "https://sf58-ies-music-sg.tiktokcdn.com/obj/tiktok-obj/6909292322614627074.mp3";
        url = "https://www.tiktok.com/@mukhtiar54/video/6938492187365625090";
        url = "https://www.tiktok.com/@mukhtiar54/video/6938492187365625090";
        //Настраиваем поток и подключаемся к URL видео


        InputStream inputStream = new URL(url).openStream();
//        InputStream inputStream = new URL("https://www.tiktok.com/@shredmonstercalves/video/6946481892875111685?is_from_webapp=v1&is_copy_url=0&sender_device=pc&sender_web_id=6946815878051251718").openStream();

        // Настраиваем буфер для хранения байтов входного потока в
        // Это может быть что угодно, но 512 - нормальный размер буфера
        byte[] videoBuffer = new byte[512];

        // Настраиваем поток вывода файла
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        /*
		 * Когда потоки заканчиваются (это означает, что мы скачали все видео)
         * он вернет '-1'
         * Пока мы сохраняем байты в videoBuffer из inputStream
         * и поток не равен -1, записываем каждый байт из буфера в файл.
		 * Когда поток равен -1, закройте файл по завершении видео.
		 */
        int len;
        while((len = inputStream.read(videoBuffer)) != -1) {
            fileOutputStream.write(videoBuffer, 0, len);
        }

        // Закрываем файловый поток
        fileOutputStream.close();

        // Готово сообщение
        System.out.println("Video Downloaded!");




    }
}
