# import redis
import time

# 获取连接
# conn = redis.Redis()

# 一周的时间
ONE_WEEK_IN_SECONDS = 7 * 86400
# 添加分数
VOTE_SCORE = 432


# 添加分数
def article_vote(conn, user, article):
    cutoff = time.time() - ONE_WEEK_IN_SECONDS
    if conn.zscore('time:', article) < cutoff:
        return

    article_id = article.partition(':')[-1]
    if conn.sadd('voted:' + article_id, user):
        conn.zincrby('score:', article, VOTE_SCORE)
        conn.hincrby(article, 'votes', 1)


# 发布文章
def post_article(conn, user, title, link):
    article_id = str(conn.incr('article:'))
    voted = 'voted:' + article_id
    conn.sadd(voted, user)
    conn.expire(voted, ONE_WEEK_IN_SECONDS)
    now = time.time();
    article = 'article:' + article_id
    conn.hmset(article, {'title': title, 'link': link, 'poster': user, 'time': now, 'votes': 1})
    conn.zadd('score:', article, now + VOTE_SCORE)
    conn.zadd('time:', article, now)
    return article_id


# 每页多少条
ARTICLES_PER_PAGE = 25


# 取出多条记录
def get_article(conn, page, order='score:'):
    start = (page - 1) * ARTICLES_PER_PAGE
    end = start + ARTICLES_PER_PAGE - 1

    ids = conn.zrevrange(order, start, end)
    articles = []

    for id in ids:
        article_data = conn.hgetall(id)
        article_data['id'] = id
        articles.append(article_data)

    return articles
