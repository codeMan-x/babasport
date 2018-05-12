package com.babasport.common.fdfs;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

//上传图片
public class FastDFSUtils {

	public static String uploadPic(byte[] pic, String name, long size) {
		String path = null;
		// ClientGloble 读配置文件
		ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
		try {
			ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
			// 创建tracker客户端
			TrackerClient trackerClient = new TrackerClient();
			// 建立tracker链接
			TrackerServer trackerServer = trackerClient.getConnection();
			// 创建storage客户端
			StorageServer storageServer = null;
			StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);

			// 上传文件
			String ext = FilenameUtils.getExtension(name);
			NameValuePair[] meta_list = new NameValuePair[3];
			meta_list[0] = new NameValuePair("fileName", name);
			meta_list[0] = new NameValuePair("fileExt", ext);
			meta_list[0] = new NameValuePair("fileSize", String.valueOf(size));

			path = storageClient1.upload_file1(pic, ext, meta_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
}
