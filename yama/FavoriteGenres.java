
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/*  @@DESCRIPTION
Amazon 題:最喜愛的歌曲風格.
給一堆歌手歌曲名單. 也給你告訴每個歌曲的風格. 請輸出每個人的歌曲風格.
*/

class FavoriteGenres implements IInterviewQuestion
{
    public Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs,//歌手歌曲名單 
    Map<String, List<String>> songGenres) // 風格對歌曲名對照表
    {
        Map<String, Integer> genreCount = new HashMap<>(); //某種歌曲風格的數量
        Map<String, String> song2Genre = new HashMap<>(); // 歌曲名對風格對照表
        Map<String, List<String>> m = new HashMap<>();  //  使用者名字及其風格.
        
        //將 [風格對歌曲名對照表] 轉換成 [歌曲名對風格對照表]
        //鍵值及對映值本身不可以有重覆值才能如此做.
        for(Map.Entry<String, List<String>> e : songGenres.entrySet())
        {
            // 取出每個風格相對應的歌曲清單
            for(String song: e.getValue())
            {
                song2Genre.put(song, e.getKey()); //將此風格的歌曲變成鍵值
            }
        }
         
        System.out.println(song2Genre);

        for(Map.Entry<String, List<String>> e : userSongs.entrySet())
        {  
            List<String> songs = e.getValue(); //取出每個人相對應的喜愛歌曲清單
            String singer = e.getKey(); // 歌手名
            genreCount.clear(); // 該歌手歌曲風格數量

            //預設值應該是不在比較範圍值內的最小值,才不影嚮求最大值計算結果。
             int max = Integer.MIN_VALUE;
            for(String song: songs) // 用該歌手的歌曲計算該歌手歌曲風格數量
            {
                String genre = song2Genre.get(song);
                genreCount.put(genre, genreCount.getOrDefault(genre,0) +1 );
                // 計算該風格的歌曲數量是否是最多歌的風格. 查是否該風格是該歌手的最常唱的風格
                max = Math.max( max, genreCount.get(genre)); //也可用PrioryQueue, 但慢而且沒必要.
            }

            // 由於只需要該歌手唱最多的風格，查最大值即可.
            for(Map.Entry<String,Integer> gc: genreCount.entrySet())
            {
                if(max==gc.getValue()) 
                {// 開始存入該歌手最常唱的風格，如果有一個以上風格的歌曲數量一樣，也等於該歌手風格.
                    m.put(singer, m.getOrDefault(singer, new ArrayList<String>()));
                    m.get(singer).add(gc.getKey());
                }
            }

        }

        return m;
    }

    public void performTest()
    {
        Map<String, List<String>> userSongs = new HashMap<>();
        Map<String, List<String>> songGenres = new HashMap<>();

        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));

        Map<String, List<String>> m = favoriteGenres(userSongs, songGenres);
        System.out.println(m);
    }

    public String toString() { return "Favorite Genres ([N]**) [    https://leetcode.com/discuss/interview-question/373006]: ";}

}
