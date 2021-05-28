from sanic import Sanic, response as res
from sanic.exceptions import NotFound
from time import time
from matcher import match_rank_articles

# instantiate the app object
app = Sanic("app") # __name__

# API endpoint
@app.get('/nlpGet')
async def nlpGet(req):
    
    def stringTest(input):
        myString = input
        return myString
    
    return res.json({ "message": stringTest("yolo1nlp23232") })

@app.post('/nlpPost')
async def nlpPost(req):

    message = req.json
    article_list = message['dataBaseArticles']
    searchText = message['searchText']
    result = match_rank_articles(searchText, article_list)
    print(result)

    dictionary = {'result': result}

    return res.json(dictionary)

# start the server
if __name__ == "__main__":
  app.run(port=5000)