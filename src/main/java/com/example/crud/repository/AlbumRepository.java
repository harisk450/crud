package com.example.crud.repository;

import com.example.crud.model.Album;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {

    List<Album> albumList = new ArrayList<>();
    public Album getAlbum() {
        Album album = new Album(234,"Harus","King pin", "https://images.app.goo.gl/tuWWGfccUrq2Lzo87");
        return  album;
    }


    public Album saveAlbum(@RequestBody Album album) {
        album.setAlbumId(albumList.size() +1);
        albumList.add(album);
        return album;
    }

    public List<Album> getAllAlbums() {
        return albumList;
    }

    public Album getAlbumById(int albumId) {
        for (Album album:albumList){
            if(album.getAlbumId() == albumId){
                return album;
            }

        }
        return null;
    }

    public Album updateAlbum(int albumId, Album album) {
        for (Album a: albumList){
            if(a.getAlbumId()== albumId){
                a.setName(album.getName());
                a.setCoverPicUrl(album.getCoverPicUrl());
                a.setDescription(album.getDescription());
                return a;
            }
        }
        return null;
    }

    public Album deleteAlbum(int albumId) {
        for (Album a:albumList){
            Album deletedAlbum = null;
            if (a.getAlbumId() == albumId){
                deletedAlbum = a;
                albumList.remove(a);
                return deletedAlbum;

            }
        }
        return null;
    }
}
