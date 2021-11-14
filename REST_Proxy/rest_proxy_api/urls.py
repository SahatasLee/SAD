from django.urls import path

from . import views

urlpatterns = [
    path('', views.index),
    path('timezone/', views.time),
    path('timezone/<str:area>', views.time),
    path('timezone/<str:area>/<str:locate>', views.time),
]