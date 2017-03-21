package com.jared.helloffmpeg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jared.helloffmpeg.model.Comment;
import com.jared.helloffmpeg.model.MyUser;
import com.jared.helloffmpeg.model.Post;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final MyUser user = new MyUser();
        user.setAge(11);
        user.save(new SaveListener<String>() {

            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    Log.i("bmob","保存成功");
                    // 创建帖子信息
                    final Post post = new Post();
                    post.setContent("xiami");
//添加一对一关联
                    post.setAuthor(user);
                    post.save(new SaveListener<String>() {

                        @Override
                        public void done(String objectId,BmobException e) {
                            if(e==null){
                                Log.i("bmob","保存成功");
                                final Comment comment = new Comment();
                                comment.setContent("what tf");
                                comment.setPost(post);
                                comment.setUser(user);
                                comment.save(new SaveListener<String>() {

                                    @Override
                                    public void done(String objectId,BmobException e) {
                                        if(e==null){
                                            Log.i("bmob","评论发表成功");
                                        }else{
                                            Log.i("bmob","失败："+e.getMessage());
                                        }
                                    }

                                });
                            }else{
                                Log.i("bmob","保存失败："+e.getMessage());
                            }
                        }
                    });
                }else{
                    Log.i("bmob","保存失败："+e.getMessage());
                }
            }
        });


        // Example of a call to a native method
        //TextView tv = (TextView) findViewById(R.id.sample_text);
        //tv.setText(avformatinfo());
    }



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
//
//    public native String urlprotocolinfo();
//    public native String avformatinfo();
//    public native String avcodecinfo();
//    public native String avfilterinfo();
//
//    // Used to load the 'native-lib' library on application startup.
//    static {
//        loadLibrary("native-lib");
//    }
}
