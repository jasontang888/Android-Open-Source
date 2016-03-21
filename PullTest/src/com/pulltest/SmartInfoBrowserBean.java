package com.pulltest;

import java.util.List;
//import com.thoughtworks.xstream.annotations.XStreamAlias;
//import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 
 * @author jasson.tang
 * 
 *         Nov 5, 2015 9:11:20 AM
 */

//@XStreamAlias("SmartInfoBrowser")
public class SmartInfoBrowserBean {

	private String					SchemaVersion;
	private SmartInfoDetailsBean	SmartInfoDetails;
	private Tilesbean				Tiles;

	@Override
	public String toString() {
		return "SmartInfoBrowserBean [SchemaVersion=" + SchemaVersion + ", SmartInfoDetails="
				+ SmartInfoDetails + ", Tiles=" + Tiles + "]";
	}

	/**
	 * @return the schemaVersion
	 */
	public String getSchemaVersion() {
		return SchemaVersion;
	}

	/**
	 * @param schemaVersion
	 *            the schemaVersion to set
	 */
	public void setSchemaVersion(String schemaVersion) {
		SchemaVersion = schemaVersion;
	}

	/**
	 * @return the tiles
	 */
	public Tilesbean getTilesbean() {
		return Tiles;
	}

	/**
	 * @param tiles
	 *            the tiles to set
	 */
	public void setTilesbean(Tilesbean tiles) {
		Tiles = tiles;
	}

	/**
	 * @return the tiles
	 */
	public Tilesbean getTilbean() {
		return Tiles;
	}

	/**
	 * @param tiles
	 *            the tiles to set
	 */
	public void setTilebean(Tilesbean tiles) {
		Tiles = tiles;
	}

	/**
	 * @return the smartInfoDetails
	 */
	public SmartInfoDetailsBean getSmartInfoDetails() {
		return SmartInfoDetails;
	}

	/**
	 * @param smartInfoDetails
	 *            the smartInfoDetails to set
	 */
	public void setSmartInfoDetails(SmartInfoDetailsBean smartInfoDetails) {
		SmartInfoDetails = smartInfoDetails;
	}

	//@XStreamAlias("Tiles")
	public static class Tilesbean {
	//	@XStreamImplicit
		private List<TileBean>	Tiles;

		/**
		 * @param tiles
		 *            the tiles to set
		 */
		public void setTiles(List<TileBean> tiles) {
			Tiles = tiles;
		}

		/**
		 * @return the tiles
		 */
		public List<TileBean> getTiles() {
			return Tiles;
		}

		@Override
		public String toString() {
			return "Tilesbean [Tiles=" + Tiles + "]";
		}

	}

	//@XStreamAlias("SmartInfoDetails")
	public static class SmartInfoDetailsBean {

		private String	Title;
		private String	Icon;
		private String	Description;
		private String	StartPageURL;

		/**
		 * @return the title
		 */
		public String getTitle() {
			return Title;
		}

		/**
		 * @param title
		 *            the title to set
		 */
		public void setTitle(String title) {
			Title = title;
		}

		/**
		 * @return the icon
		 */
		public String getIcon() {
			return Icon;
		}

		/**
		 * @param icon
		 *            the icon to set
		 */
		public void setIcon(String icon) {
			Icon = icon;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return Description;
		}

		/**
		 * @param description
		 *            the description to set
		 */
		public void setDescription(String description) {
			Description = description;
		}

		/**
		 * @return the startPageURL
		 */
		public String getStartPageURL() {
			return StartPageURL;
		}

		/**
		 * @param startPageURL
		 *            the startPageURL to set
		 */
		public void setStartPageURL(String startPageURL) {
			StartPageURL = startPageURL;
		}

		@Override
		public String toString() {
			return "SmartInfoDetailsBean [Title=" + Title + ", Icon=" + Icon + ", Description="
					+ Description + ", StartPageURL=" + StartPageURL + "]";
		}

	}

	//@XStreamAlias("Tile")
	public static class TileBean {
		private String	Icon;
		private String	IconThumbnail;
		private String	Label;
		private String	Link;

		/**
		 * @return the icon
		 */
		public String getIcon() {
			return Icon;
		}

		/**
		 * @param icon
		 *            the icon to set
		 */
		public void setIcon(String icon) {
			Icon = icon;
		}

		/**
		 * @return the iconThumbnail
		 */
		public String getIconThumbnail() {
			return IconThumbnail;
		}

		/**
		 * @param iconThumbnail
		 *            the iconThumbnail to set
		 */
		public void setIconThumbnail(String iconThumbnail) {
			IconThumbnail = iconThumbnail;
		}

		/**
		 * @return the label
		 */
		public String getLabel() {
			return Label;
		}

		/**
		 * @param label
		 *            the label to set
		 */
		public void setLabel(String label) {
			Label = label;
		}

		/**
		 * @return the link
		 */
		public String getLink() {
			return Link;
		}

		/**
		 * @param link
		 *            the link to set
		 */
		public void setLink(String link) {
			Link = link;
		}

		@Override
		public String toString() {
			return "TileBean [Icon=" + Icon + ", IconThumbnail=" + IconThumbnail + ", Label="
					+ Label + ", Link=" + Link + "]";
		}

	}
}
