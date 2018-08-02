package com.like.news.mvp.model.bean

/**

 * 作者：like on 2018/8/1 17:54

 * 邮箱：like@tydic.com

 * 描述：

 */

data class PublicNews(
    val created_at: String,
    val id: Long,
    val idstr: String,
    val mid: String,
    val can_edit: Boolean,
    val text: String,
    val textLength: Int,
    val source_allowclick: Int,
    val source_type: Int,
    val source: String,
    val favorited: Boolean,
    val truncated: Boolean,
    val in_reply_to_status_id: String,
    val in_reply_to_user_id: String,
    val in_reply_to_screen_name: String,
    val pic_urls: List<PicUrl>,
    val thumbnail_pic: String,
    val bmiddle_pic: String,
    val original_pic: String,
    val geo: Any,
    val is_paid: Boolean,
    val mblog_vip_type: Int,
    val user: User,
    val annotations: List<Annotation>,
    val picStatus: String,
    val reposts_count: Int,
    val comments_count: Int,
    val attitudes_count: Int,
    val pending_approval_count: Int,
    val isLongText: Boolean,
    val hide_flag: Int,
    val mlevel: Int,
    val visible: Visible,
    val biz_feature: Long,
    val topic_id: String,
    val sync_mblog: Boolean,
    val is_imported_topic: Boolean,
    val page_type: Int,
    val hasActionTypeCard: Int,
    val darwin_tags: List<Any>,
    val hot_weibo_tags: List<Any>,
    val text_tag_tips: List<Any>,
    val mblogtype: Int,
    val userType: Int,
    val more_info_type: Int,
    val positive_recom_flag: Int,
    val content_auth: Int,
    val gif_ids: String,
    val is_show_bulletin: Int,
    val comment_manage_info: CommentManageInfo
)

data class Visible(
    val type: Int,
    val list_id: Int
)

data class CommentManageInfo(
    val comment_permission_type: Int,
    val approval_comment_type: Int
)

data class User(
    val id: Long,
    val idstr: String,
    val clazz : Int,
    val screen_name: String,
    val name: String,
    val province: String,
    val city: String,
    val location: String,
    val description: String,
    val url: String,
    val profile_image_url: String,
    val cover_image_phone: String,
    val profile_url: String,
    val domain: String,
    val weihao: String,
    val gender: String,
    val followers_count: Int,
    val friends_count: Int,
    val pagefriends_count: Int,
    val statuses_count: Int,
    val video_status_count: Int,
    val favourites_count: Int,
    val created_at: String,
    val following: Boolean,
    val allow_all_act_msg: Boolean,
    val geo_enabled: Boolean,
    val verified: Boolean,
    val verified_type: Int,
    val remark: String,
    val insecurity: Insecurity,
    val ptype: Int,
    val allow_all_comment: Boolean,
    val avatar_large: String,
    val avatar_hd: String,
    val verified_reason: String,
    val verified_trade: String,
    val verified_reason_url: String,
    val verified_source: String,
    val verified_source_url: String,
    val follow_me: Boolean,
    val like: Boolean,
    val like_me: Boolean,
    val online_status: Int,
    val bi_followers_count: Int,
    val lang: String,
    val star: Int,
    val mbtype: Int,
    val mbrank: Int,
    val block_word: Int,
    val block_app: Int,
    val credit_score: Int,
    val user_ability: Int,
    val urank: Int,
    val story_read_state: Int,
    val vclub_member: Int
)

data class Insecurity(
    val sexual_content: Boolean
)

data class PicUrl(
    val thumbnail_pic: String
)

data class Annotation(
    val client_mblogid: String,
    val mapi_request: Boolean
)