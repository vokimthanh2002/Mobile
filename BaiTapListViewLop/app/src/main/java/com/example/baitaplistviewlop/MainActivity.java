package com.example.baitaplistviewlop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String ffo=" FIFA Online 4 Việt Nam chính thức phát hành phiên bản điện thoại. Từ nay bạn có thể thỏa giấc mơ sân cỏ mọi lúc mọi nơi một cách dễ dàng.FIFA Online 4 Việt Nam có bản quyền hơn 32 giải đấu và 15000 cầu thủ trên toàn thế giới. Xây dựng đội bóng trong mơ giờ đây là điều trong tầm tay bạn.Dữ liệu hoàn toàn đồng bộ với FIFA Online 4 trên máy tính giúp việc quản lý đội bóng, nâng cấp, mua bán cầu thủ trên thị trường chuyển nhượng và mở các vật phẩm sẽ nhanh chóng, tiện lợi hơn bao giờ hết.";
    final String pubg="Game Battle Royale nguyên bản, đầu tiên và hay nhất! Game Battle Royale được hơn 1 tỷ người chơi trên toàn thế giới bình chọn.\n" +
            "Kiệt tác huyền thoại battle royale.Nhiều sự kiện đang chờ bạn khám phá.Đạt đến đỉnh cao trong PUBG MOBILE, thỏa sức bắn tùy thích. PUBG MOBILE là trò chơi battle royale nguyên bản trên di động, và là một trong những trò chơi bắn súng hay nhất.";
    final String gta="Hệ thống online của GTA V là lý do khiến tựa game này luôn nằm trong top những game bán chạy nhất. Được cập nhật hàng tháng với rất nhiều nội dung mới được thêm vào, cũng như là những nhiệm vụ và các thử thách mới để người chơi chinh phục. Một tựa game với thành phố Los Santos lộng lẫy cùng với thiên nhiên tuyệt đẹp như Grand Theft Auto V mà chỉ chơi đơn thì rất uổng phí, hệ thống online của game cho phép bạn và bạn bè của mình đi khám phá cả thành phố rộng lớn Los Santos, hoặc cùng nhau làm những phi vụ độc nhất vô nhị mà GTA V mang lại cho người chơi.";
    final String mig="Minecraft là 1 trong những trò chơi sinh tồn thế giới mở phong cách đồ họa Pixel đình đám nhất hiện nay. Chuyên mục Minecraft sẽ mang đến cho các game thủ GameVui một sân chơi game Minecraft trực tuyến vui nhộn. Rất nhiều trò chơi Minecraft hay - sân chơi của những khối vuông kỳ diệu - đang chờ bạn khám phá đấy!";
    final String warcraft="Toàn bộ nội dung trong game đều diễn ra tại vùng đất thần thoại Azeroth. Ban đầu, nội dung game tập trung vào các tộc người xây dựng nên đế chế Eastern Kingdoms và Orcish Horde, kết nối với Azeroth thông qua Dark Portal. Tộc Orc đến từ thế một thế giới khác, được gọi là Draenor, vùng đất này bị ma thuật hắc ám phá tan thành từng mảnh trong sự kiện Warcraft II, sau này được biết đến với tên gọi Outland. Về sau, thế giới Azeroth được mở rộng, nhiều lục địa mới được khám phá như Kalimdor, Northrend, Pandaria, Broken Isles, Kul Tiras, và Zandalar. Theo đó, vũ trụ Warcraft giới thiệu hàng loạt tuyến nhân vật mới như Night Elves, Tauren, Pandaren, v.v... Thế giới Azeroth cũng tồn tại những chủng tộc huyền thoại truyền thống như: yêu tinh, người lùn, quỷ lùn,...";
    final String ff="Với tất cả niềm đam mê chơi Garena Free Fire, đôi tay của bạn sẽ không còn bị giới hạn trên một màn hình nhỏ của điện thoại. Trải nghiệm chơi như một người chuyên nghiệp và kiểm soát hoàn toàn trò chơi của bạn bằng bàn phím và chuột. MEmu cung cấp cho bạn tất cả những điều mà bạn đang mong đợi. Tải xuống và chơi Garena Free Fire trên PC. Miễn là bạn muốn chơi, bởi nó không còn giới hạn về pin, dữ liệu di động và các cuộc gọi làm phiền. MEmu 7 hoàn toàn là sự lựa chọn tốt nhất để chơi Garena Free Fire trên PC. Với sự chuẩn bị về chuyên môn của chúng tôi, hệ thống sơ đồ bàn phím tinh tế làm cho Garena Free Fire trở thành một trò chơi thực sự trên PC. Trình Quản lý đa năng, đã được chăm chút bởi sự tiếp thu của chúng tôi, có thể phát 2 hoặc nhiều tài khoản trên cùng một thiết bị. Và điều quan trọng nhất, công cụ mô phỏng độc quyền của chúng tôi có thể phát huy toàn bộ tiềm năng PC của bạn, giúp mọi thứ hoạt động trơn tru nhất có thể. Chúng tôi biết rằng quá trình tận hưởng hạnh phúc ở mỗi trò chơi cũng là mong muốn của mỗi game thủ, vì vậy các bạn chỉ cần chơi thôi hãy để chúng tôi quan tâm đến tất cả trải nghiệm đó.";
    final String lq="Garena Liên Quân Mobile có nguồn gốc từ trò chơi Vương Giả Vinh Diệu (Honor of Kings) của Tencent Games phát triển và phát hành tại Trung Quốc. Vì trò chơi Vương Giả Vinh Diệu có những nhân vật trong lịch sử Trung Quốc nên không phát hành ở nước ngoài. Vì vậy Tencent Games đã thay đổi, cải thiện hình ảnh các nhân vật lên quốc tế hóa và phân phối cho Garena phát hành tại thị trường Đài Loan với tên Truyền Thuyết Đối Quyết (tiếng Trung: 傳說對決) vào ngày 14/10/2016. Về sau trò chơi được Garena phát hành ở các nước Đông Nam Á còn lại và do chính Tencent Games phát hành ở Châu Âu, Châu Mỹ và Ấn Độ.";
    final String lmht ="Liên Minh Huyền Thoại là một trò chơi đấu trường chiến đấu trực tuyến (MOBA) nhiều người chơi, trong đó người chơi điều khiển một nhân vật (\"Triệu hồi sư\") với một loạt các khả năng độc đáo từ góc nhìn đẳng hướng hoặc từ trên xuống. Trong suốt một trận đấu, các Tướng tăng cấp bằng cách nhận được điểm kinh nghiệm (XP) thông qua việc tiêu diệt những kẻ thù không phải người chơi được gọi là lính. Các vật phẩm cũng giúp tăng sức mạnh của tướng và được mua bằng vàng kiếm được khi giết lính hoặc phá hủy các công trình của đối phương.Trong chế độ chơi chính, Summoner's Rift, các vật phẩm được mua thông qua menu cửa hàng chỉ dành cho người chơi khi tướng của họ ở trong căn cứ của đội. Mỗi trận đấu đều rời rạc; cấp độ và vật phẩm không chuyển từ trận đấu này sang trận đấu khác";
    final String csGo= "CS:GO mang đến sự trải nghiệm đặc biệt cho rất nhiều game thủ, và nếu bạn thích game bắn súng, hãy tải game ngay trên Steam và bắt đầu hành trình trải nghiệm. Kể từ tháng 12 năm 2018, CS:GO đã được phát hành miễn phí. Bạn có thể chơi nó ngay cả trên những chiếc máy tính lỗi thời thông qua dịch vụ đám mây GeForce Now. Điều này khiến CS:GO vẫn phổ biến vào năm 2021 và có lẽ cả trong nhiều năm tới.";
    ListView listViewGame;
    ArrayList<Game> gameArrayList;
    AdapterGame3 adapterGame3;
    EditText edtTenGame,edtMoTa,edtDungLuong;
    Button btnthem,btnSUa,btnXoa;
    int vitri =-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewGame =(ListView) findViewById(R.id.ListViewGame);
        gameArrayList = new ArrayList<>();
        gameArrayList.add(new Game("3145MB",csGo,"CS Go",R.drawable.csgo,"Game bắn súng"));
        gameArrayList.add(new Game("3144MB",lmht,"Lien Minh Huyen Thoai",R.drawable.lmht,"Game chiến thuật"));
        gameArrayList.add(new Game("3214MB",ffo,"Fifa online 4",R.drawable.ffo,"Game đá bóng"));
        gameArrayList.add(new Game("3314MB",lq,"Lien quan mobile",R.drawable.lq,"Game chiến thuật"));
        gameArrayList.add(new Game("3414MB",mig,"Minecraft",R.drawable.mig,"Game phiêu lưu"));
        gameArrayList.add(new Game("3154MB",pubg,"Pubg",R.drawable.pubg,"Game bắn súng"));
        gameArrayList.add(new Game("3414MB",ff,"Free Fire",R.drawable.ff,"Game bắn súng"));
        gameArrayList.add(new Game("3134MB",gta,"Gta 5",R.drawable.gta,"Game khám phá"));
        gameArrayList.add(new Game("3714MB",warcraft,"Warcraft",R.drawable.warcraft,"Game phiêu lưu"));
        gameArrayList.add(new Game("314MB",csGo,"CS Go",R.drawable.csgo,"Game bắn súng"));
        gameArrayList.add(new Game("3148MB",lmht,"Lien Minh Huyen Thoai",R.drawable.lmht,"Game bắn súng"));
        gameArrayList.add(new Game("3714MB",ffo,"Fifa online 4",R.drawable.ffo,"Game đá bóng"));
        gameArrayList.add(new Game("314MB",lq,"Lien quan mobile",R.drawable.lq,"Game chiến thuật"));
        gameArrayList.add(new Game("3614MB",mig,"Minecraft",R.drawable.mig,"Game phiêu lưu"));
        gameArrayList.add(new Game("3174MB",pubg,"Pubg",R.drawable.pubg,"Game bắn súng"));
        gameArrayList.add(new Game("3164MB",ff,"Free Fire",R.drawable.ff,"Game bắn súng"));
        gameArrayList.add(new Game("3145MB",csGo,"CS Go",R.drawable.csgo,"Game bắn súngg"));
        gameArrayList.add(new Game("3144MB",lmht,"Lien Minh Huyen Thoai",R.drawable.lmht,"Game chiến thuật"));
        gameArrayList.add(new Game("3214MB",ffo,"Fifa online 4",R.drawable.ffo,"Game đá bóng"));
        gameArrayList.add(new Game("3314MB",lq,"Lien quan mobile",R.drawable.lq,"Game chiến thuật"));
        gameArrayList.add(new Game("3414MB",mig,"Minecraft",R.drawable.mig,"Game phiêu lưu"));
        gameArrayList.add(new Game("3154MB",pubg,"Pubg",R.drawable.pubg,"Game bắn súng"));
        gameArrayList.add(new Game("3414MB",ff,"Free Fire",R.drawable.ff,"Game bắn súng"));
        gameArrayList.add(new Game("3134MB",gta,"Gta 5",R.drawable.gta,"Game khám phá"));
        gameArrayList.add(new Game("3714MB",warcraft,"Warcraft",R.drawable.warcraft,"Game phiêu lưu"));
        gameArrayList.add(new Game("314MB",csGo,"CS Go",R.drawable.csgo,"Game bắn súng"));
        adapterGame3 = new AdapterGame3(MainActivity.this,R.layout.custom_dong_game,gameArrayList);
        listViewGame.setAdapter(adapterGame3);
        edtTenGame=(EditText) findViewById(R.id.txtTenGame);
        edtMoTa=(EditText) findViewById(R.id.txt_MoTa);
        edtDungLuong=(EditText) findViewById(R.id.txt_DungLuong);
        btnthem=(Button) findViewById(R.id.btnThem);
        btnSUa=(Button) findViewById(R.id.btnSua);
        btnXoa=(Button) findViewById(R.id.btnXoa);

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtTenGame.getText().length()!=0&&edtMoTa.getText().length()!=0&&edtDungLuong.getText().length()!=0){
                    Game game = new Game(edtTenGame.getText().toString(),edtMoTa.getText().toString(),edtDungLuong.getText().toString());
                    gameArrayList.add(game);
                    adapterGame3.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Them moi thanh cong!!", Toast.LENGTH_SHORT).show();
                    edtTenGame.setText("");
                    edtMoTa.setText("");
                    edtDungLuong.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "Vui lonh nhap du thong tin can xoa", Toast.LENGTH_SHORT).show();
                }
            }
        });
        listViewGame.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitri=i;
                edtTenGame.setText(gameArrayList.get(i).getTenGame());
                edtMoTa.setText(gameArrayList.get(i).getMoTa());
                edtDungLuong.setText(gameArrayList.get(i).getDungLuong());

            }
        });
        listViewGame.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Game game= new Game(edtTenGame.getText().toString(),edtMoTa.getText().toString(),edtDungLuong.getText().toString());
                gameArrayList.remove(game);
                adapterGame3.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        btnSUa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtTenGame.getText().length()!=0&&edtMoTa.getText().length()!=0&&edtDungLuong.getText().length()!=0){
                    gameArrayList.get(vitri).setTenGame(edtTenGame.getText().toString());
                    gameArrayList.get(vitri).setMoTa(edtMoTa.getText().toString());
                    gameArrayList.get(vitri).setDungLuong(edtDungLuong.getText().toString());
                    adapterGame3.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Nhap ten game can sua", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtTenGame.getText().length()!=0&&edtMoTa.getText().length()!=0&&edtDungLuong.getText().length()!=0){
                    Game game= new Game(edtTenGame.getText().toString(),edtMoTa.getText().toString(),edtDungLuong.getText().toString());
                    gameArrayList.remove(game);
                    adapterGame3.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Nhap ten game can xoa", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}
