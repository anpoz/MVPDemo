package com.playcode.mvpdemo.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class ArticleList {

    /**
     * date : 20160820
     * stories : [{"images":["http://pic1.zhimg.com/bda264573a5b6f61adc319e16a6cf81c.jpg"],"type":0,"id":8703598,"ga_prefix":"082009","title":"「你看我给你画了个圈，只要不出这个圈，你干啥都行」"},{"images":["http://pic3.zhimg.com/53348dd45ebdd8700729bd57f97988e6.jpg"],"type":0,"id":8703512,"ga_prefix":"082008","title":"手术完了纱布丢了，医生的内心也是崩溃的"},{"images":["http://pic3.zhimg.com/17ca2bbc5693cce96e5862b7cdd16d46.jpg"],"type":0,"id":8706106,"ga_prefix":"082007","title":"审计人员要找公司的每个人都好好聊聊，也是个技术活"},{"images":["http://pic3.zhimg.com/c7b4b25c09d1fec56a976ff636e18eba.jpg"],"type":0,"id":8693719,"ga_prefix":"082007","title":"如果鸟是恐龙演化来的，那\u2026\u2026恐龙岂不是没有灭绝？"},{"title":"这些年走遍世界各地，吃到了很多奇奇怪怪的东西","ga_prefix":"082007","images":["http://pic4.zhimg.com/a565dca8b323b3ee012c263fba58cf07.jpg"],"multipic":true,"type":0,"id":8689727},{"images":["http://pic1.zhimg.com/fab45a90a94b86dd5c9a74e41f625138.jpg"],"type":0,"id":8706363,"ga_prefix":"082007","title":"读读日报 24 小时热门 TOP 5 · 就喜欢你看不惯我又拿我没办法的样子"},{"images":["http://pic1.zhimg.com/973b6158b95f10474d332560db70e9d0.jpg"],"type":0,"id":8702579,"ga_prefix":"082006","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic1.zhimg.com/8f1a981e5d5286325aca06ba28acdeec.jpg","type":0,"id":8706363,"ga_prefix":"082007","title":"读读日报 24 小时热门 TOP 5 · 就喜欢你看不惯我又拿我没办法的样子"},{"image":"http://pic1.zhimg.com/032043b82035915bcb4afb8b1add39c4.jpg","type":0,"id":8689727,"ga_prefix":"082007","title":"这些年走遍世界各地，吃到了很多奇奇怪怪的东西"},{"image":"http://pic1.zhimg.com/f6471351244ba398a1695b3aba7b5018.jpg","type":0,"id":8704402,"ga_prefix":"081920","title":"整点儿奥运 · 女排精神一直都在"},{"image":"http://pic3.zhimg.com/25c2d0a4f50af050c9b545df5bd69472.jpg","type":0,"id":8702551,"ga_prefix":"081914","title":"国外孩子真的自己挣钱上大学吗 ？"},{"image":"http://pic1.zhimg.com/73731a2633534288f3cb2f8f184666f4.jpg","type":0,"id":8679437,"ga_prefix":"081917","title":"知乎好问题 · 有哪些小病不及时治疗，发展到最后难以挽救的病例？"}]
     */

    private String date;
    /**
     * images : ["http://pic1.zhimg.com/bda264573a5b6f61adc319e16a6cf81c.jpg"]
     * type : 0
     * id : 8703598
     * ga_prefix : 082009
     * title : 「你看我给你画了个圈，只要不出这个圈，你干啥都行」
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic1.zhimg.com/8f1a981e5d5286325aca06ba28acdeec.jpg
     * type : 0
     * id : 8706363
     * ga_prefix : 082007
     * title : 读读日报 24 小时热门 TOP 5 · 就喜欢你看不惯我又拿我没办法的样子
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
