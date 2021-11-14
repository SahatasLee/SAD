
from django.http import HttpResponse
import requests
import json
from django.core.cache import cache
# Create your views here.
url = "http://worldtimeapi.org/api/timezone/"
def index(request):
    res = requests.get(url)
    data = res.json()
    return HttpResponse(json.dumps(data), content_type='application/json')

def time(request, area='', locate=''):
    my_key = str(area + '/' + locate)
    print(my_key)
    if my_key not in cache:
        # res = cache.get(my_key)
        # data = res.json()
        # print(data)
        # return HttpResponse(json.dumps(data), content_type='application/json')
        res = requests.get(url + my_key)
        cache.set(my_key, res, 10)
        data = res.json()
        print('from server')
        return HttpResponse(json.dumps(data), content_type='application/json')
    else:
        # res = requests.get(url + my_key)
        # cache.set(my_key, res, 120)
        # data = res.json()
        # print('from server')
        # return HttpResponse(json.dumps(data), content_type='application/json')
        print('from cache')
        res = cache.get(my_key)
        data = res.json()
        # print('from cache')
        return HttpResponse(json.dumps(data), content_type='application/json')

